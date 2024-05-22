package com.github.biomejs.intellijbiome.services

import com.github.biomejs.intellijbiome.BiomeBundle
<<<<<<< HEAD
import com.github.biomejs.intellijbiome.listeners.BiomeEditorPanelListener
import com.github.biomejs.intellijbiome.lsp.BiomeLspServerManagerListener
=======
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
import com.github.biomejs.intellijbiome.lsp.BiomeLspServerSupportProvider
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.components.Service
<<<<<<< HEAD
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
=======
import com.intellij.openapi.project.Project
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
import com.intellij.platform.lsp.api.LspServerManager

@Service(Service.Level.PROJECT)
class BiomeServerService(private val project: Project) {
<<<<<<< HEAD
    private val editorPanelListener: BiomeEditorPanelListener

    init {
        addBiomeLspListener()
        editorPanelListener = BiomeEditorPanelListener(project)
        project.messageBus.connect().subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, editorPanelListener)
    }

    fun getCurrentConfigPath(): String? {
        return editorPanelListener.getCurrentConfigPath()
    }

=======
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
    fun restartBiomeServer() {
        LspServerManager.getInstance(project).stopAndRestartIfNeeded(BiomeLspServerSupportProvider::class.java)
    }

<<<<<<< HEAD
    fun addBiomeLspListener() {
        LspServerManager.getInstance(project)
            .addLspServerManagerListener(BiomeLspServerManagerListener(project), Disposer.newDisposable(), true)
    }

=======
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
    fun stopBiomeServer() {
        LspServerManager.getInstance(project).stopServers(BiomeLspServerSupportProvider::class.java)
    }

    fun notifyRestart() {
        NotificationGroupManager.getInstance()
            .getNotificationGroup("Biome")
            .createNotification(
                BiomeBundle.message("biome.language.server.restarted"),
                "",
                NotificationType.INFORMATION
            )
            .notify(project)
    }
}
