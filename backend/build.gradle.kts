plugins {
    id("com.xlinks.buildlogic.spring-boot-application")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":sync"))
    implementation(project(":storage"))
    implementation(project(":api"))

    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.springframework.modulith:spring-modulith-starter-jpa")
    runtimeOnly("org.postgresql:postgresql:42.7.5")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
}