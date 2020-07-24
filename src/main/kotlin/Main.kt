import com.github.ckaag.service.factory.builder.xml.ServiceBuilder
import java.io.File
import java.io.StringReader
import javax.xml.bind.JAXBContext

fun main() {
    val xml = exampleServiceXml
    val model = parseServiceXmlToModel(xml)
    val output: Map<String, String> = model.formatAsJavaFilesForOutput()
    output.entries.forEach { println(it.key + ":\n====\n" + it.value + "\n========\n\n") }
    
    output.forEach { filepath, filecontent -> File(filepath).writeText(filecontent) }
}


fun parseServiceXmlToModel(xml: String): ServiceModel {
    val jaxbContext = JAXBContext.newInstance(ServiceBuilder::class.java)

    System.setProperty("javax.xml.accessExternalDTD", "all")
    
    val jaxbUnmarshaller = jaxbContext.createUnmarshaller()

    val serviceBuilderXml = jaxbUnmarshaller!!.unmarshal(StringReader(xml)) as ServiceBuilder;

    return transformIntoModel(serviceBuilderXml)
}

fun transformIntoModel(builderXml: ServiceBuilder): ServiceModel {
    return ServiceModel(
        builderXml.entity.map { rawEntity ->
            ServiceEntity(builderXml.packagePath, builderXml.namespace, rawEntity.name,
                rawEntity.column.map { rawColumn ->
                    EntityColumn(
                        rawColumn.name,
                        if (rawColumn.type == "Collection") "List<${rawColumn.entity}>" else rawColumn.type,
                        true,
                        "true" == rawColumn.primary
                    )
                })
        }
    )
}

data class ServiceModel(val entities: List<ServiceEntity>) {
    fun formatAsJavaFilesForOutput(): Map<String, String> {
        return entities.map { formatOutputClassFilepath(it) to formatOutputClassFile(it) }.toMap()
    }
}

private fun formatOutputClassFilepath(e: ServiceEntity): String {
    return "./src/main/java/${e.pckge.packageToPath()}/factory/${e.name}Builder.java"
}

private fun String.packageToPath(): String {
    return this.replace('.', '/')
}

data class ServiceEntity(val pckge: String, val namespace: String, val name: String, val columns: List<EntityColumn>) {

    fun getAllColumns(): List<EntityColumn> = this.columns.toList() + this.hardRefColumns
    fun generateIdParamsWithType(): String {
        //comma separated list of all parts of the primary key, as used for a parameter list
        return getAllColumns().filter { it.primaryKey }.map { it.type + " " + it.name.decapitalize() }
            .joinToString(", ")
    }

    fun generateIdParamsWithoutType(): String {
        //comma separated list of all parts of the primary key, as used for a callee list
        return getAllColumns().filter { it.primaryKey }.map { it.name.decapitalize() }.joinToString(", ")
    }

    val hardRefColumns = listOf<EntityColumn>() //TODO: add things uuid etc.
}

data class EntityColumn(
    val name: String,
    val type: String,
    val required: Boolean = true,
    val primaryKey: Boolean = false
) {
    fun isObjectType(): Boolean = getDefaultValueForType(type) == "null"
}


fun formatOutputClassFile(e: ServiceEntity): String {
    val builder = e.name + "Factory"
    val prefix = """package ${e.pckge}.factory;
        
        import ${e.pckge}.model.*;
        import ${e.pckge}.service.*;
        import java.util.*;
        
        public class ${builder} {
            
            private ${builder}() {}
            
            public static ${builder} builder() {
                return new ${builder}();
            }

    """.trimIndent()

    val functionDefinitions = StringBuilder()
    val finalBuildMethod = StringBuilder()

    finalBuildMethod.appendln(
        """//TODO: add a second builder that generates a new id (this one can just generate a new id via counterlocalservice)
            public ${e.name} build(${e.generateIdParamsWithType()}, ${e.name}LocalService service) {
            ${e.name} entity = service.create${e.name}(${e.generateIdParamsWithoutType()});
            """
    )

    e.getAllColumns().forEach { col ->
        if (!col.primaryKey) {
            functionDefinitions.appendln(
                """
                private ${col.type} _${col.name} = ${getDefaultValueForType(col.type)};
                
                public ${col.type} get${col.name}() {
                    return this._${col.name};
                }
                
                public ${builder} set${col.name}(${col.type} value) {
                    this._${col.name} = value;
                    return this;
                }
            """.trimIndent()
            )
            if (col.required && col.isObjectType()) {
                finalBuildMethod.appendln("""require(this._${col.name});""");
            }
            finalBuildMethod.appendln("""entity.set${col.name}(this._${col.name});""")
        }
    }

    finalBuildMethod.appendln(
        """
            return entity;
        }
    """.trimIndent()
    )

    return "$prefix$functionDefinitions\n}\n"
}

fun getDefaultValueForType(type: String): String {
    return when (type) {
        "byte" -> "0"
        "short" -> "0"
        "int" -> "0"
        "long" -> "0L"
        "float" -> "0.0f"
        "double" -> "0.0d"
        "boolean" -> "false"
        "char" -> "'\\u0000'"
        else -> "null"
    }
}
