package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import utils.implementation
import utils.ksp
import utils.testImplementation

fun DependencyHandler.androidx() {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(platform(Dependencies.COMPOSE_BOM))
    implementation(Dependencies.UI)
    implementation(Dependencies.UI_GRAPHICS)
    implementation(Dependencies.UI_TOOLING)
    implementation(Dependencies.UI_TOOLING_PREVIEW)
    implementation(Dependencies.MATERIAL)
}

fun DependencyHandler.junit() {
    testImplementation(Dependencies.JUNIT)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.HILT)
    ksp(Dependencies.HILT_COMPILER)
}

fun DependencyHandler.hiltNavigation() {
    implementation(Dependencies.HILT_NAVIGATION)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.CONVERTER_GSON)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.NAVIGATION_COMPOSE)
    implementation(Dependencies.SERIALIZATION)
}

fun DependencyHandler.coil() {
    implementation(Dependencies.COIL)
}

fun DependencyHandler.systemUiController() {
    implementation(Dependencies.SYSTEM_UI_CONTROLLER)
}

fun DependencyHandler.splashScreen() {
    implementation(Dependencies.SPLASH_SCREEN)
}