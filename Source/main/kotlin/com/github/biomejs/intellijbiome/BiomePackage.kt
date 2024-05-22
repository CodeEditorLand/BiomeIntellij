package com.github.biomejs.intellijbiome

import com.github.biomejs.intellijbiome.extensions.runBiomeCLI
import com.github.biomejs.intellijbiome.settings.BiomeSettings
import com.github.biomejs.intellijbiome.settings.ConfigurationMode
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.util.ExecUtil
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.util.NodePackage
import com.intellij.openapi.project.Project
<<<<<<< HEAD
import com.intellij.openapi.vfs.VirtualFile
=======
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
import java.nio.file.Paths

class BiomePackage(private val project: Project) {
    private val interpreter = NodeJsInterpreterManager.getInstance(project).interpreter
    private val nodePackage: NodePackage?
        get() {
            return NodePackage.findDefaultPackage(project, "@biomejs/biome", interpreter)
        }

<<<<<<< HEAD
    fun configPath(file: VirtualFile): String? {
        val settings = BiomeSettings.getInstance(project)
        val configurationMode = settings.configurationMode
        return when (configurationMode) {
            ConfigurationMode.DISABLED -> null
            ConfigurationMode.AUTOMATIC -> findPathUpwards(file, configValidExtensions.map { "$configName.$it" })?.path
            ConfigurationMode.MANUAL -> settings.configPath
        }
    }
=======
    val configPath: String?
        get() {
            val settings = BiomeSettings.getInstance(project)
            val configurationMode = settings.configurationMode

            return when (configurationMode) {
                ConfigurationMode.DISABLED -> null
                ConfigurationMode.AUTOMATIC -> null
                ConfigurationMode.MANUAL -> BiomeSettings.getInstance(project).configPath
            }
        }
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7

    fun versionNumber(): String? {
        val settings = BiomeSettings.getInstance(project)
        val configurationMode = settings.configurationMode
        return when (configurationMode) {
            ConfigurationMode.DISABLED -> null
            ConfigurationMode.AUTOMATIC -> nodePackage?.getVersion(project)?.toString()
<<<<<<< HEAD
            ConfigurationMode.MANUAL -> getBinaryVersion(binaryPath(null, true))
        }
    }

    fun binaryPath(configPath: String?, showVersion: Boolean): String? {
=======
            ConfigurationMode.MANUAL -> getBinaryVersion(binaryPath())
        }
    }

    fun binaryPath(): String? {
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
        val settings = BiomeSettings.getInstance(project)
        val configurationMode = settings.configurationMode
        return when (configurationMode) {
            ConfigurationMode.DISABLED -> null
<<<<<<< HEAD
            // don't try to find the executable path if the configuration file does not exist.
            // This will prevent start LSP and formatting in case if biome is not used in the project.
            ConfigurationMode.AUTOMATIC -> if (configPath != null || showVersion) findBiomeExecutable() else null
            // if configuration mode is manual, return the executable path if it is not empty string.
            // Otherwise, try to find the executable path.
            ConfigurationMode.MANUAL -> if (settings.executablePath == "") findBiomeExecutable() else settings.executablePath
        }
    }

    private fun findBiomeExecutable() = nodePackage?.getAbsolutePackagePathToRequire(project)?.let {
        Paths.get(
            it,
            "bin/biome"
        )
    }?.toString()

=======
            ConfigurationMode.AUTOMATIC -> nodePackage?.getAbsolutePackagePathToRequire(project)?.let {
                Paths.get(
                    it,
                    "bin/biome"
                )
            }?.toString()

            ConfigurationMode.MANUAL -> settings.executablePath
        }
    }

>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7

    private fun getBinaryVersion(binaryPath: String?): String? {
        if (binaryPath.isNullOrEmpty()) {
            return null
        }

        val versionRegex = Regex("\\d{1,2}\\.\\d{1,2}\\.\\d{1,3}")
        val commandLine = GeneralCommandLine().runBiomeCLI(project, binaryPath).apply {
            addParameter("--version")
        }

        return runCatching {
            val output = ExecUtil.execAndGetOutput(commandLine)
            val matchResult = versionRegex.find(output.stdout)
            return matchResult?.value
        }.getOrNull()
    }

    companion object {
        const val configName = "biome"
        val configValidExtensions = listOf("json", "jsonc")
    }
<<<<<<< HEAD

    private fun findPathUpwards(file: VirtualFile, fileName: List<String>): VirtualFile? {
        var cur = file.parent
        while (cur != null) {
            if (cur.children.find { name -> fileName.any { it == name.name } } != null) {
                return cur
            }
            cur = cur.parent
        }
        return null
    }
=======
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
}
