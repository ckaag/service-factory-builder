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
import com.github.ckaag.service.factory.builder.hints.Field
import com.github.ckaag.service.factory.builder.hints.Model
import com.github.ckaag.service.factory.builder.hints.ModelHints
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
    return model.formatAsJavaFilesForOutput(typedMode)
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

fun String?.asAttributes(): EntityHints? {
    if (this == null) return null

    val jaxbContext = JAXBContext.newInstance(ModelHints::class.java)

    System.setProperty("javax.xml.accessExternalDTD", "all")

    val jaxbUnmarshaller = jaxbContext.createUnmarshaller()

    val modelHintsXml = jaxbUnmarshaller!!.unmarshal(StringReader(this)) as ModelHints


    return transformToEntityHints(modelHintsXml)
}

fun transformToEntityHints(modelHintsXml: ModelHints): EntityHints {
    val inner: List<Pair<String, EntityAttributes>?> = modelHintsXml.hintCollectionOrModel.map { ent ->
        when (ent) {
            is Model -> {
                Pair(
                    ent.name,
                    EntityAttributes(
                        ent.defaultHintsOrField.flatMap { field ->
                            when (field) {
                                is Field -> {
                                    val fieldname = field.name
                                    field.hintCollectionOrHintOrSanitizeOrValidator.map { validator ->
                                        when (validator) {
                                            is com.github.ckaag.service.factory.builder.hints.Validator -> {

                                                if (validator.name == "required") fieldname else null
                                            }
                                            else -> null
                                        }
                                    }
                                }
                                else -> listOf()
                            }.filterNotNull()
                        }.toSet()
                    )
                )
            }
            else -> {
                println("is not a model: " + ent.javaClass.name)
                null
            }
        }
    }
    return EntityHints(inner.filterNotNull().toMap())
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
                        hintXml?.entityNameToAttributes?.get(builderXml.packagePath + ".model." + rawEntity.name)?.requiredFields?.contains(
                            rawColumn.name
                        ) ?: false,
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

private fun formatOutputClassFilepath(e: ServiceEntity, missingFields: Set<String>): Path {
    val cn = formatClassName(e.name, missingFields.toList())
    val subpath = "${e.pckge.packageToPath()}/factory/${cn}Factory.java"
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
        return getAllColumns().filter { it.primaryKey }.joinToString(", ") { it.type + " " + it.name.decapitalize() }
    }

    fun generateIdParamsWithoutType(): String {
        //comma separated list of all parts of the primary key, as used for a callee list
        return getAllColumns().filter { it.primaryKey }.joinToString(", ") { it.name.decapitalize() }
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

private fun plus(set: Set<String>, x: String): Set<String> {
    val m = mutableSetOf<String>()
    set.forEach { m.add(it) }
    m.add(x)
    return m
}

private fun formatOutputJavaFileContent(
    e: ServiceEntity,
    missingRequiredFields: Set<String>,
    allRequiredFields: Set<String>
): String {

    val className = formatClassName(e.name, missingRequiredFields.toList())
    fun classNameWithout(fieldName: String): String =
        formatClassName(e.name, missingRequiredFields.filter { it != fieldName })

    fun classNameWith(fieldName: String): String =
        formatClassName(e.name, plus(missingRequiredFields, fieldName).toList())

    fun builderWithout(fieldName: String): String = classNameWithout(fieldName) + "Factory"
    fun builderWith(fieldName: String): String = classNameWith(fieldName) + "Factory"
    val emptyBuilder = formatClassName(e.name, allRequiredFields.toList()) + "Factory"

    val builder = className + "Factory"
    var prefix = """package ${e.pckge}.factory;
        
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import ${e.pckge}.model.*;
import ${e.pckge}.service.*;
import ${e.pckge}.service.persistence.*;
import java.util.*;
        
public class $builder {
            
    private ${builder}() {}
    
    private static void require(Object object) {
        Objects.requireNonNull(object);
    }

"""

    if (missingRequiredFields.isEmpty()) {
        prefix += """
            
    public static $emptyBuilder builder() {
        return new ${emptyBuilder}();
    }

        """
    }

    val functionDefinitions = StringBuilder()
    val finalBuildMethod = StringBuilder()
    val copyConstructorMethods: Map<String, StringBuilder> = allRequiredFields.map { Pair(it, StringBuilder()) }.toMap()

    if (allRequiredFields.isNotEmpty()) {
        //create copy constructors that will be called from other setters
        copyConstructorMethods.forEach { (columnNameThatWasAdded, sb) ->
            sb.appendln(
                """
                    public ${builder}(${builderWith(columnNameThatWasAdded)} other) {
                """.trimIndent()
            )
        }
        //("copy all fields from previous builder to new instance without setters but using getters on old")
    }

    if (missingRequiredFields.isEmpty()) {
        if (e.hasLocalService) {
            finalBuildMethod.appendln(
                """
            public $className build(${className}LocalService service) {
                return this.build(CounterLocalServiceUtil.increment(${className}.class.getName()), service);
            }
            
            public $className build(${e.generateIdParamsWithType()}, ${className}LocalService service) {
            $className entity = service.create${className}(${e.generateIdParamsWithoutType()});
            return this.build(entity);
            }
            """
            )
        } else {
            finalBuildMethod.appendln(
                """//TODO: add a second builder that generates a new id (this one can just generate a new id via counterlocalservice)
            public $className build(${className}Persistence persistence) {
                return this.build(CounterLocalServiceUtil.increment(${className}.class.getName()), persistence);
            }
            
            public $className build(${e.generateIdParamsWithType()}, ${className}Persistence persistence) {
            $className entity = persistence.create(${e.generateIdParamsWithoutType()});
            return this.build(entity);
            }
            """
            )
        }
    }
    if (missingRequiredFields.isEmpty()) {
        finalBuildMethod.appendln(
            """
        public $className build(${className} entity) {
    """.trimIndent()
        )
    }

    e.getAllColumns().forEach { col ->
        if (!col.primaryKey) {
            if (col.type != null) {

                if (allRequiredFields.isNotEmpty()) {
                    //("add column to copy constructors from other.get{col.name}")
                    copyConstructorMethods.forEach { (_, sb) ->
                        sb.appendln("""this._${col.name} = other.get{col.name}();""")
                    }
                }


                functionDefinitions.appendln(
                    """
                private ${col.type} _${col.name} = ${getDefaultValueForType(col.type)};
                
                public ${col.type} get${col.name}() {
                    return this._${col.name};
                }""".trimIndent()
                )
                if (missingRequiredFields.contains(col.name)) {
                    functionDefinitions.appendln(
                        """
                public ${builderWithout(col.name)} set${col.name}(${col.type} value) {
                    return ${builderWithout(col.name)}(this).set${col.name}(value);
                }
            """.trimIndent()
                    )
                } else {
                    functionDefinitions.appendln(
                        """
                public $builder set${col.name}(${col.type} value) {
                    this._${col.name} = value;
                    return this;
                }
            """.trimIndent()
                    )
                }
                if (missingRequiredFields.isEmpty()) {
                    if (col.required && col.isObjectType() == true) {
                        finalBuildMethod.appendln("""require(this._${col.name});""")
                    }
                    if (col.isObjectType() != null) {
                        finalBuildMethod.appendln("""entity.set${col.name}(this._${col.name});""")
                    }
                }
            }
        }
    }

    if (missingRequiredFields.isEmpty()) {
        finalBuildMethod.appendln(
            """
            return entity;
        }
    """.trimIndent()
        )
    }


    if (allRequiredFields.isNotEmpty()) {
        //finish up with copy constructors
        copyConstructorMethods.forEach { it.value.appendln("\n}\n") }
    }


    //there will only be a build method if all required fields were set at least
    return "$prefix$functionDefinitions\n$finalBuildMethod\n${copyConstructorMethods.map { it.value.toString() }
        .joinToString("\n")}\n\n}\n"
}

private fun formatClassName(baseClassName: String, missingRequiredFields: List<String>): String {
    return if (missingRequiredFields.isEmpty()) baseClassName else formatClassName(
        "${baseClassName}_without_${missingRequiredFields.first()}",
        missingRequiredFields.drop(1)
    )
}

//finds all partial sets (but excludes empty sets)
fun <T> buildPartialSubsets(baseFullSet: Set<T>, includeItselfInOutput: Boolean, includeEmpty: Boolean): Set<Set<T>> {
    val items = baseFullSet.toList()
    val output = mutableListOf<Set<T>>()
    val baseList = baseFullSet.toList()
    (items.size - 1 downTo 1).forEach { n ->
        val i: List<List<T>> = buildSubsetHelper(baseList, n)
        i.forEach { k ->
            output.add(k.toSet())
        }
    }
    if (includeItselfInOutput) {
        output.add(baseFullSet)
    }
    if (includeEmpty) {
        output.add(setOf())
    }
    return output.toSet()
}

//recursive helper function
private fun <T> buildSubsetHelper(fullSet: List<T>, n: Int): List<List<T>> {
    if (fullSet.isEmpty()) return emptyList()
    val l = fullSet.toList()
    return if (n == 1) {
        l.map { listOf(it) }
    } else {
        val o: List<List<T>> = l.mapIndexed { idx, pivot ->
            val rest = l.filterIndexed { index, _ -> index != idx }
            val lower = buildSubsetHelper(rest, n - 1)
            lower.map { it + pivot }
        }.flatten()
        o
    }
}

fun formatOutputClassFile(e: ServiceEntity, typedMode: Boolean): Map<Path, String> {
    if (typedMode) {
        val reqFields: Set<String> = e.getRequiredFieldNames()
        val permutes = buildPartialSubsets(reqFields, true, true)
        return permutes.map { perm ->
            val filename: Path = formatOutputClassFilepath(e, perm)
            val content: String = formatOutputJavaFileContent(e, perm, reqFields)
            Pair(filename, content)
        }.toMap()
    } else {
        val missingFields = setOf<String>()
        val simpleClass = formatOutputJavaFileContent(e, missingFields, missingFields)
        return mapOf(Pair(formatOutputClassFilepath(e, missingFields), simpleClass))
    }
}

private fun ServiceEntity.getRequiredFieldNames(): Set<String> {
    return this.columns.filter { it.required }.map { it.name }.toSet()
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
