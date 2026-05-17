rootProject.name = "xlinks"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

include("core", "sync", "storage", "api", "backend")

// Include custom build logic
includeBuild("gradle/build-logic")
