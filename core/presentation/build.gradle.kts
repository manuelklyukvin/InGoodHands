import configs.GradleNamespaces
import configs.GradleVersions
import dependencies.androidx
import dependencies.coil
import dependencies.navigation
import dependencies.systemUiController

plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = GradleNamespaces.CORE
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
    buildFeatures {
        compose = true
    }
}

dependencies {
    androidx()
    navigation()
    coil()
    systemUiController()
}