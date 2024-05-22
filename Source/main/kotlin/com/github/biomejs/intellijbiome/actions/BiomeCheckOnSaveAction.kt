package com.github.biomejs.intellijbiome.actions

<<<<<<< HEAD
=======
import com.github.biomejs.intellijbiome.Feature
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
import com.github.biomejs.intellijbiome.settings.BiomeSettings
import com.intellij.ide.actionsOnSave.impl.ActionsOnSaveFileDocumentManagerListener
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project
<<<<<<< HEAD
=======
import java.util.*
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7


class BiomeCheckOnSaveAction() :
    ActionsOnSaveFileDocumentManagerListener.ActionOnSave() {
<<<<<<< HEAD
    override fun isEnabledForProject(project: Project): Boolean {
        val settings = BiomeSettings.getInstance(project)

=======
    private var features: EnumSet<Feature> = EnumSet.noneOf(Feature::class.java)
    override fun isEnabledForProject(project: Project): Boolean {
        val settings = BiomeSettings.getInstance(project)

        setFeatures(settings)

>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
        return settings.formatOnSave || settings.applySafeFixesOnSave || settings.applyUnsafeFixesOnSave
    }

    override fun processDocuments(project: Project, documents: Array<Document>) {
<<<<<<< HEAD
        val settings = BiomeSettings.getInstance(project)
        BiomeCheckRunner().run(project, settings.getEnabledFeatures(), documents)
=======
        BiomeCheckRunner().run(project, features, documents)
    }

    private fun setFeatures(settings: BiomeSettings) {
        features = EnumSet.noneOf(Feature::class.java)

        if (settings.formatOnSave) {
            features.add(Feature.Format)
        }

        if (settings.applySafeFixesOnSave) {
            features.add(Feature.SafeFixes)
        }

        if (settings.applyUnsafeFixesOnSave) {
            features.add(Feature.UnsafeFixes)
        }
>>>>>>> a1d4e0e301649dfcf5d3c1d9d5a2f0bd30f144d7
    }
}
