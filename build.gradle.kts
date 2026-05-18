// Fixed root build.gradle.kts for Spring Boot 4 + Kotlin 2.1 + Java 21
plugins {
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    java
}

group = "com.halexiev"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
