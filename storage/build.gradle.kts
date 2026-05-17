plugins {
    id("com.xlinks.buildlogic.kotlin-jvm")
}

dependencies {
    implementation(project(":core"))
    implementation("software.amazon.awssdk:s3:2.44.7")
    implementation("com.azure:azure-storage-blob:12.35.0")
    implementation("com.google.cloud:google-cloud-storage:2.67.0")
}