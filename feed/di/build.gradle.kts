import configs.GradleNamespaces
import gradle_plugins.DiGradlePlugin
import modules.coreData
import modules.feedData
import modules.feedDomain

apply<DiGradlePlugin>()

plugins {
    `android-library`
    `kotlin-android`
}

android {
    namespace = GradleNamespaces.FEED_DI
}

dependencies {
    coreData()
    feedDomain()
    feedData()
}