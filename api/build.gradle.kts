plugins {
    id("com.xlinks.buildlogic.kotlin-jvm")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":sync"))
    implementation(project(":storage"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
}