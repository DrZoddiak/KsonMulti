plugins {
    kotlin("multiplatform") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
    `maven-publish`

}

group = "me.zodd"
version = "1.7.2"

val mavenPublishingUrl = "https://repo.zodd.me/releases"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    afterEvaluate {
        configure<PublishingExtension> {
            val mavenPublication = this as? MavenPublication
            mavenPublication?.artifactId = "${project.name}${
                "-$name".takeUnless {
                    "kotlinMultiplatform" in name
                }.orEmpty()
            }"
        }
        //May be ok to delete.
        tasks.named("generateMetadataFileForMavenPublishPublication") {
            dependsOn("metadataJar")
        }
    }

    publishing {
        publications {
            create<MavenPublication>("mavenPublish") {
                artifactId = "KsonMulti"
                groupId = project.group as String
                version = project.version.toString()

                repositories {
                    maven {
                        setUrl(mavenPublishingUrl)
                        credentials {
                            username = project.properties["mavenUser"] as String?
                            password = project.properties["mavenPassword"] as String?
                        }
                        authentication {
                            create<BasicAuthentication>("basic")
                        }
                    }
                }
            }
        }
    }



    sourceSets {
        //COMMON
        val commonMain by getting {
            dependencies {
                api("io.ktor:ktor-client-serialization:2.3.1")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
                api("io.ktor:ktor-client-core:2.3.1")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.1")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
                implementation(kotlin("test"))
            }
        }
        //JVM
        val jvmMain by getting {
            dependencies {
                api(kotlin("stdlib-jdk8"))
                api("io.ktor:ktor-client-cio:2.3.1")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
                api(kotlin("reflect"))
            }
        }
        val jvmTest by getting {
            dependencies {
            }
        }
    }
}


