plugins {
    kotlin("multiplatform") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    `maven-publish`
}

group = "me.zodd"
version = "1.2.0"

val mavenPublishingUrl = "https://repo.zodd.me/releases"

repositories {
    mavenCentral()
}



kotlin {
    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
            }
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser()
        nodejs()
        useCommonJs()
    }

    afterEvaluate {
        configure<PublishingExtension>() {
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
                            username = project.properties["mavenUser"] as String
                            password = project.properties["mavenPassword"] as String
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
                api("io.ktor:ktor-client-serialization:1.6.7")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
                api("io.ktor:ktor-client-core:1.6.7")
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
                api("io.ktor:ktor-client-cio:1.6.7")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
                api(kotlin("reflect"))
            }
        }
        val jvmTest by getting {
            dependencies {
            }
        }
        //JS
        val jsMain by getting {
            dependencies {
                api("io.ktor:ktor-client-js:1.6.7")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}



