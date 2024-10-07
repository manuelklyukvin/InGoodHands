import configs.GradleNamespaces
import dependencies.retrofit
import gradle_plugins.PresentationGradlePlugin
import modules.feedData
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
    retrofit()
    feedDomain()
    feedData()
}