import configs.GradleNamespaces
import gradle_plugins.PresentationGradlePlugin
import modules.feedDi
import modules.feedDomain

apply<PresentationGradlePlugin>()

plugins {
    `android-library`
    `kotlin-android`
}

android {
    namespace = GradleNamespaces.FEED_PRESENTATION
}

dependencies {
    feedDomain()
    feedDi()
}