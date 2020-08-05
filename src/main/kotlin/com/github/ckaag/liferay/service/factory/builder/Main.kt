package com.github.ckaag.liferay.service.factory.builder

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import com.github.ckaag.service.factory.builder.xml.ServiceBuilder
import exampleServiceXml
import java.io.File
import java.io.StringReader
import javax.xml.bind.JAXBContext


fun main(args: Array<String>) = ServiceFactoryBuilder().main(args)

const val ROOT_JAVA_SRC_DIR = "./src/main/java/"

class ServiceFactoryBuilder : CliktCommand() {

    val typedMode: Boolean by option("-t", "--typed").flag()
    val transientMode: Boolean by option("-z", "--transient").flag()
    val forceMode: Boolean by option("-f", "--force").flag()
    val inputXmlFiles: List<File> by option("-i", "--input-files").file().multiple(required = true)
    val outputDirectory: File by option("-o", "--output-directory").file().default(File(ROOT_JAVA_SRC_DIR))

    override fun run() {
        if (forceMode || outputDirectory.hasMavenOrGradleProjectRoot()) {
            val xmlFiles: List<String> = inputXmlFiles.map { it.readText() }
            xmlFiles.forEach { xml ->
                generateOutput(outputDirectory, xml, typedMode).logOutput().writeOutputToDisk(transientMode)
            }
        } else {
            throw UnsupportedOperationException("outputdirectory '${outputDirectory.canonicalPath}' does not seem to be part of a maven or gradle project structure, this might be wrongly used. Use '-f' to skip this check and generate the sources regardless of this problem.")
        }
    }
}

private fun File.hasMavenOrGradleProjectRoot(): Boolean {
    val mvnRoot = this.resolve("./../../../")
    return mvnRoot.resolve("build.gradle").exists() || mvnRoot.resolve("pom.xml").exists()
}

typealias FactoryOutput = Map<String, String>

fun generateOutput(targetOutputDirectory: File, inputXml: String, typedMode: Boolean): FactoryOutput {
    val model = parseServiceXmlToModel(inputXml)
    val output: Map<String, String> = model.formatAsJavaFilesForOutput(targetOutputDirectory, typedMode)
    return output
}

fun FactoryOutput.logOutput(): FactoryOutput {
    this.entries.forEach { println(it.key + ":\n====\n" + it.value + "\n========\n\n") }
    return this
}

fun FactoryOutput.writeOutputToDisk(transientMode: Boolean = false): FactoryOutput {
    if (!transientMode) {
        this.forEach { filepath, filecontent -> writeFile(filepath, filecontent) }
    }
    return this
}

fun withExampleServiceXml() {
    val xml = exampleServiceXml
    generateOutput(File(ROOT_JAVA_SRC_DIR), xml, false).logOutput().writeOutputToDisk()
}

fun writeFile(filepath: String, filecontent: String) {
    val f = File(filepath).canonicalFile
    println(f.absolutePath)
    f.parentFile.mkdirs()
    File(filepath).writeText(filecontent)
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
            ServiceEntity(rawEntity.localService == "true",
                rawEntity.remoteService == "true",
                builderXml.packagePath,
                builderXml.namespace,
                rawEntity.name,
                rawEntity.column.map { rawColumn ->
                    EntityColumn(
                        rawColumn.name.capitalize(),
                        if (rawColumn.type == "Collection") null else rawColumn.type,
                        true,
                        "true" == rawColumn.primary
                    )
                })
        }
    )
}

data class ServiceModel(val entities: List<ServiceEntity>) {
    fun formatAsJavaFilesForOutput(targetSrcRootDirectory: File, typedMode: Boolean): Map<String, String> {
        return entities.map {
            formatOutputClassFilepath(it, targetSrcRootDirectory) to formatOutputClassFile(
                it,
                typedMode
            )
        }.toMap()
    }
}

private fun formatOutputClassFilepath(e: ServiceEntity, targetSrcRootDirectory: File): String {
    return "./src/main/java/${e.pckge.packageToPath()}/factory/${e.name}Factory.java"
}

private fun String.packageToPath(): String {
    return this.replace('.', '/')
}

data class ServiceEntity(
    val hasLocalService: Boolean,
    val hasRemoteService: Boolean,
    val pckge: String,
    val namespace: String,
    val name: String,
    val columns: List<EntityColumn>
) {

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
    val type: String?,
    val required: Boolean = true,
    val primaryKey: Boolean = false
) {
    fun isObjectType(): Boolean? = type?.let { getDefaultValueForType(it) == "null" }
}


fun formatOutputClassFile(e: ServiceEntity, typedMode: Boolean): String {
    val builder = e.name + "Factory"
    val prefix = """package ${e.pckge}.factory;
        
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import ${e.pckge}.model.*;
import ${e.pckge}.service.*;
import ${e.pckge}.service.persistence.*;
import java.util.*;
        
public class ${builder} {
            
    private ${builder}() {}
    
    private static void require(Object object) {
        Objects.requireNonNull(object);
    }

    public static ${builder} builder() {
        return new ${builder}();
    }

"""

    val functionDefinitions = StringBuilder()
    val finalBuildMethod = StringBuilder()

    if (e.hasLocalService) {
        finalBuildMethod.appendln(
            """
            public ${e.name} build(${e.name}LocalService service) {
                return this.build(CounterLocalServiceUtil.increment(${e.name}.class.getName()), service);
            }
            
            public ${e.name} build(${e.generateIdParamsWithType()}, ${e.name}LocalService service) {
            ${e.name} entity = service.create${e.name}(${e.generateIdParamsWithoutType()});
            return this.build(entity);
            }
            """
        )
    } else {
        finalBuildMethod.appendln(
            """//TODO: add a second builder that generates a new id (this one can just generate a new id via counterlocalservice)
            public ${e.name} build(${e.name}Persistence persistence) {
                return this.build(CounterLocalServiceUtil.increment(${e.name}.class.getName()), persistence);
            }
            
            public ${e.name} build(${e.generateIdParamsWithType()}, ${e.name}Persistence persistence) {
            ${e.name} entity = persistence.create(${e.generateIdParamsWithoutType()});
            return this.build(entity);
            }
            """
        )
    }

    finalBuildMethod.appendln(
        """
        public ${e.name} build(${e.name} entity) {
    """.trimIndent()
    )

    e.getAllColumns().forEach { col ->
        if (!col.primaryKey) {
            if (col.type != null) {
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
                if (col.required && col.isObjectType() == true) {
                    finalBuildMethod.appendln("""require(this._${col.name});""");
                }
                if (col.isObjectType() != null) {
                    finalBuildMethod.appendln("""entity.set${col.name}(this._${col.name});""")
                }
            }
        }
    }

    finalBuildMethod.appendln(
        """
            return entity;
        }
    """.trimIndent()
    )

    return "$prefix$functionDefinitions\n$finalBuildMethod\n\n}\n"
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
