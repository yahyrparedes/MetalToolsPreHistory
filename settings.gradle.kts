rootProject.name = "MetalToolsPreHistory"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        // Use google() sin filtros para que el plugin de Android pueda resolverse
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        // Para dependencias normales permitimos google() y mavenCentral()
        google()
        mavenCentral()
    }
}

include(":composeApp")