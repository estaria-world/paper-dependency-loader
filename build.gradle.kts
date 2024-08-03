plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.0"
}

group = "world.estaria"
version = "1.0.1"

repositories {
    mavenCentral()

    // papermc repositories
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(kotlin("stdlib"))

    // paper dependencies
    compileOnly("io.papermc.paper:paper-api:1.21.0-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}