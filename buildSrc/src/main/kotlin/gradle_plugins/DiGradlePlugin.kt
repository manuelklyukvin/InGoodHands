package gradle_plugins

import configs.GradleVersions
import dependencies.hilt
import dependencies.retrofit
import org.gradle.api.Project
import utils.android

class DiGradlePlugin : CoreGradlePlugin() {

    override fun setPlugins(project: Project) {
        project.apply {
            plugin("android-library")
            plugin("kotlin-android")
            plugin("com.google.devtools.ksp")
            plugin("com.google.dagger.hilt.android")
        }
    }

    override fun setProjectConfig(project: Project) {
        project.android().apply {
            compileSdk = GradleVersions.COMPILE_SDK

            defaultConfig {
                minSdk = GradleVersions.MIN_SDK
            }
            buildTypes {
                release {
                    isMinifyEnabled = true
                }
            }
            compileOptions {
                sourceCompatibility = GradleVersions.JAVA
                targetCompatibility = GradleVersions.JAVA
            }
        }
    }

    override fun setDependencies(project: Project) {
        project.dependencies.apply {
            hilt()
            retrofit()
        }
    }
}