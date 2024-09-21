pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "In Good Hands"
include(":app")
include(
    ":core",
    ":core:presentation",
    ":core:domain",
    ":core:data"
)

include(
    ":feed",
    ":feed:presentation",
    ":feed:domain",
    ":feed:data",
    ":feed:di"
)