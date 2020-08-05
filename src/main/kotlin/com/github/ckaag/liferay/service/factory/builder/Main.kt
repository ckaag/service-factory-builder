package com.github.ckaag.liferay.service.factory.builder

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import com.github.ajalt.clikt.parameters.types.path
import com.github.ckaag.liferay.service.factory.builder.mock.Dependencies
import com.github.ckaag.liferay.service.factory.builder.mock.LogOutput
import com.github.ckaag.liferay.service.factory.builder.mock.OutputFileWriter
import com.github.ckaag.service.factory.builder.xml.ServiceBuilder
import java.io.File
import java.io.StringReader
import java.nio.file.Path
import java.nio.file.Paths
import javax.xml.bind.JAXBContext


fun main(args: Array<String>) = ServiceFactoryBuilder().main(args)

const val ROOT_JAVA_SRC_DIR = "./src/main/java/"

class ServiceFactoryBuilder : CliktCommand() {

    val typedMode: Boolean by option("-t", "--typed").flag()
    val transientMode: Boolean by option("-z", "--transient").flag()
    val forceMode: Boolean by option("-f", "--force").flag()
    val inputXmlFiles: List<File> by option("-i", "--input-files").file().multiple(required = true)
    val outputDirectory: Path by option("-o", "--output-directory").path().default(Path.of(ROOT_JAVA_SRC_DIR))

    val dependencies =
        Dependencies(LogOutput.PrintlnOutputFileWriter(), OutputFileWriter.DiskOutputFileWriter(outputDirectory))

    override fun run() {
        if (forceMode || outputDirectory.hasMavenOrGradleProjectRoot()) {
            inputXmlFiles.forEach { xmlFile ->
                val xml: String = xmlFile.readText()
                val hintXml: String? = findHintXml(xmlFile)
                generateOutput(xml, hintXml, typedMode).logOutput(dependencies)
                    .writeOutputToDisk(dependencies, transientMode)
            }
        } else {
            throw UnsupportedOperationException("outputdirectory '${outputDirectory.toFile().canonicalPath}' does not seem to be part of a maven or gradle project structure, this might be wrongly used. Use '-f' to skip this check and generate the sources regardless of this problem.")
        }
    }

}


private fun findHintXml(xmlFile: File): String? {
    val file: File? = xmlFile.resolveSibling("./src/main/resources/META-INF/portlet-model-hints.xml")
    return if (file != null && file.isFile && file.canRead()) {
        file.readText()
    } else {
        null
    }
}

private fun Path.hasMavenOrGradleProjectRoot(): Boolean {
    val mvnRoot = this.resolve("./../../../")
    return mvnRoot.resolve("build.gradle.kts").exists() || mvnRoot.resolve("build.gradle")
        .exists() || mvnRoot.resolve("pom.xml").exists()
}

private fun Path.exists(): Boolean = this.toFile().let { it.exists() && it.canRead() }

typealias FactoryOutput = Map<Path, String>

fun generateOutput(inputServiceXml: String, hintXml: String?, typedMode: Boolean): FactoryOutput {
    val model = parseServiceXmlToModel(inputServiceXml, hintXml)
    val output: FactoryOutput = model.formatAsJavaFilesForOutput(typedMode)
    return output
}

fun FactoryOutput.logOutput(dependencies: Dependencies): FactoryOutput {
    this.entries.forEach { dependencies.log.output(it.key.toString() + ":\n====\n" + it.value + "\n========\n\n") }
    return this
}

fun FactoryOutput.writeOutputToDisk(dependencies: Dependencies, transientMode: Boolean = false): FactoryOutput {
    if (!transientMode) {
        this.forEach { (filepath, filecontent) -> writeFile(dependencies, filepath, filecontent) }
    }
    return this
}

fun writeFile(
    dependencies: Dependencies,
    filepath: Path,
    filecontent: String
) {
    val f = filepath.toFile().canonicalFile
    dependencies.log.info(f.absolutePath)
    f.parentFile.mkdirs()
    f.writeText(filecontent)
    dependencies.writer.write(filepath, filecontent)
}


fun parseServiceXmlToModel(xml: String, hintXml: String?): ServiceModel {
    val jaxbContext = JAXBContext.newInstance(ServiceBuilder::class.java)

    System.setProperty("javax.xml.accessExternalDTD", "all")

    val jaxbUnmarshaller = jaxbContext.createUnmarshaller()

    val serviceBuilderXml = jaxbUnmarshaller!!.unmarshal(StringReader(xml)) as ServiceBuilder

    return transformIntoModel(serviceBuilderXml, hintXml.asAttributes())
}

data class EntityHints(val entityNameToAttributes: Map<String, EntityAttributes>)

data class EntityAttributes(val requiredFields: Set<String>)

fun String?.asAttributes() : EntityHints? {
    if (this == null) return null
    TODO("entity hints parsing not yet implemented")
}

fun transformIntoModel(builderXml: ServiceBuilder, hintXml: EntityHints?): ServiceModel {
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
                        hintXml?.entityNameToAttributes?.get(rawEntity.name)?.requiredFields?.contains(rawColumn.name)?:false,
                        "true" == rawColumn.primary
                    )
                })
        }
    )
}

data class ServiceModel(val entities: List<ServiceEntity>) {
    fun formatAsJavaFilesForOutput(typedMode: Boolean): FactoryOutput {
        return entities.flatMap {
            formatOutputClassFile(
                it,
                typedMode
            ).entries.map { entry -> Pair(entry.key, entry.value) }.toList()
        }.toMap()
    }
}

private fun formatOutputClassFilepath(e: ServiceEntity): Path {
    val subpath = "${e.pckge.packageToPath()}/factory/${e.name}Factory.java"
    return Paths.get(subpath)
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
    val required: Boolean,
    val primaryKey: Boolean
) {
    fun isObjectType(): Boolean? = type?.let { getDefaultValueForType(it) == "null" }
}


fun formatOutputClassFile(e: ServiceEntity, typedMode: Boolean): Map<Path, String> {
    if (typedMode) {
        TODO("typedMode is not yet implemented")
    }
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
                    finalBuildMethod.appendln("""require(this._${col.name});""")
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

    return mapOf(Pair(formatOutputClassFilepath(e), "$prefix$functionDefinitions\n$finalBuildMethod\n\n}\n"))
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
