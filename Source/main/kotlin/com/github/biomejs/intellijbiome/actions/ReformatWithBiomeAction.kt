package com.github.biomejs.intellijbiome.actions

<<<<<<< HEAD
=======
import com.github.biomejs.intellijbiome.Feature
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
import com.github.biomejs.intellijbiome.settings.BiomeSettings
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
<<<<<<< HEAD
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.DumbAware
=======
import com.intellij.openapi.project.DumbAware
import java.util.*
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7


class ReformatWithBiomeAction : AnAction(), DumbAware {
    override fun actionPerformed(actionEvent: AnActionEvent) {
        val project = actionEvent.project
        if (project == null || project.isDefault) return

        val editor: Editor? = actionEvent.getData(CommonDataKeys.EDITOR)

        if (editor != null) {
<<<<<<< HEAD
            val documentManager = FileDocumentManager.getInstance()
            // We should save document before running Biome, because Biome will read the file from disk and user changes can be lost
            if (documentManager.isDocumentUnsaved(editor.document)) {
                documentManager.saveDocument(editor.document)
            }
            val settings = BiomeSettings.getInstance(project)
            BiomeCheckRunner().run(project, settings.getEnabledFeatures(), arrayOf(editor.document))
=======
            BiomeCheckRunner().run(project, EnumSet.of(Feature.Format), arrayOf(editor.document))
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
        }
    }

    override fun update(actionEvent: AnActionEvent) {
        val project = actionEvent.project
        if (project == null || project.isDefault) {
            actionEvent.presentation.isEnabledAndVisible = false
            return
        }

        val settings = BiomeSettings.getInstance(project)
        actionEvent.presentation.isEnabledAndVisible = settings.isEnabled()
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }
}
