plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("plugin.serialization")
}
kotlin {
    tasks {
        shadowJar {
            archiveFileName.set("${project.parent?.name ?: project.name}.jar")
            project.setProperty("mainClassName", "")
        }
    }
}