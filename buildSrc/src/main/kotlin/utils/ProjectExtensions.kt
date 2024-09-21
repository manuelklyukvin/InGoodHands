package utils

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension

fun Project.android(): LibraryExtension {
    return extensions.getByType(LibraryExtension::class.java)
}

fun Project.java(): JavaPluginExtension {
    return extensions.getByType(JavaPluginExtension::class.java)
}