import configs.GradleNamespaces
import gradle_plugins.PresentationGradlePlugin
import modules.feedDomain

apply<PresentationGradlePlugin>()

plugins {
    `android-library`
    `kotlin-android`
}

android {
    namespace = GradleNamespaces.FEED
}

dependencies {
    feedDomain()
}