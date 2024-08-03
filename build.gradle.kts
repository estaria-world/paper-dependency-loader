import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.9.23"
}

group = "world.estaria"
version = "1.0.1"

repositories {
    mavenCentral()

    // papermc repositories
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(kotlin("stdlib"))

    // paper dependencies
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named("shadowJar", ShadowJar::class) {
    mergeServiceFiles()
}