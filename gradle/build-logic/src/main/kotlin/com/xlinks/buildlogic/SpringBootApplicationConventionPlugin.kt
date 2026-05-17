package com.xlinks.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.springframework.boot.gradle.plugin.SpringBootPlugin

class SpringBootApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply(SpringBootPlugin::class.java)
        project.plugins.apply("org.springframework.boot")
        project.plugins.apply("io.spring.dependency-management")

        // Apply our Kotlin convention
        project.plugins.apply(KotlinJvmConventionPlugin::class.java)
    }
}