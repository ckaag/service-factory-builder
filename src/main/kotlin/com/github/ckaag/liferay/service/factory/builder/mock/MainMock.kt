package com.github.ckaag.liferay.service.factory.builder.mock

import com.github.ckaag.liferay.service.factory.builder.generateOutput
import com.github.ckaag.liferay.service.factory.builder.logOutput
import com.github.ckaag.liferay.service.factory.builder.writeOutputToDisk
import java.nio.file.Path

/**
 * Created by usickaag on Mittwoch, 05.08.2020 at 10:21.
 */


sealed class OutputFileWriter {
    class MockOutputFileWriter(
        val outputs: MutableMap<Path, String> = mutableMapOf(),
        var onAdd: (Path, String) -> Unit = { i, j -> }
    ) : OutputFileWriter() {
        override fun write(path: Path, content: String) {
            this.outputs[path] = content
        }
    }

    class DiskOutputFileWriter(val rootPath: Path) : OutputFileWriter() {
        override fun write(path: Path, content: String) {
            val f = rootPath.resolve(path).toFile()
            f.parentFile.mkdirs()
            f.writeText(content, Charsets.UTF_8)
        }
    }

    abstract fun write(path: Path, content: String)
    fun write(outputs: Map<Path, String>) {
        outputs.forEach { this.write(it.key, it.value) }
    }
}

sealed class LogOutput {
    class MockLogOutput(
        val outputtedLines: MutableList<String> = mutableListOf(),
        var onAdd: (String) -> Unit = { i -> }
    ) : LogOutput() {
        override fun info(s: String) {
            println(s)
            outputtedLines.add(s)
        }
    }

    class PrintlnOutputFileWriter() : LogOutput() {
        override fun info(s: String) {
            println(s)
        }
    }

    abstract fun info(s: String)
    open fun warn(s: String) = info(s)
    open fun debug(s: String) = info(s)
    open fun error(s: String) = info(s)
    open fun output(s: String) = info(s)
}

data class Dependencies(
    val log: LogOutput = LogOutput.MockLogOutput(),
    val writer: OutputFileWriter = OutputFileWriter.MockOutputFileWriter()
)
