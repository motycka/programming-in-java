plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "java")
//    apply(plugin = "org.junit.platform.gradle.plugin")
//    apply(plugin = "org.junit.jupiter.gradle.plugin")

    dependencies {
        implementation("org.apache.logging.log4j:log4j-api:2.22.1")
        implementation("org.apache.logging.log4j:log4j-core:2.22.1")
        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
    }
}


