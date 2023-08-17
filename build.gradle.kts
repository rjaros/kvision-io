import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    val kotlinVersion: String by System.getProperties()
    kotlin("plugin.serialization") version kotlinVersion
    kotlin("multiplatform") version kotlinVersion
    val kvisionVersion: String by System.getProperties()
    id("io.kvision") version kvisionVersion
}

version = "1.0.0-SNAPSHOT"
group = "io.kvision"

repositories {
    mavenCentral()
    mavenLocal()
}

// Versions
val kotlinVersion: String by System.getProperties()
val kvisionVersion: String by System.getProperties()

kotlin {
    js {
        browser {
            runTask(Action {
                mainOutputFileName = "main.bundle.js"
                sourceMaps = false
                devServer = KotlinWebpackConfig.DevServer(
                    open = false,
                    port = 3000,
                    proxy = mutableMapOf(
                        "/kv/*" to "http://localhost:8080",
                        "/kvws/*" to mapOf("target" to "ws://localhost:8080", "ws" to true)
                    ),
                    static = mutableListOf("$buildDir/processedResources/js/main")
                )
            })
            webpackTask(Action {
                mainOutputFileName = "main.bundle.js"
            })
            testTask(Action {
                useKarma {
                    useChromeHeadless()
                }
            })
        }
        binaries.executable()
    }
    sourceSets["jsMain"].dependencies {
        implementation(npm("sass", "^1.29.0"))
        implementation(npm("sass-loader", "^10.1.0"))
        implementation(npm("marked", "^1.2.4"))
        implementation(npm("smooth-scroll", "^16.1.3"))
        implementation(npm("@types/smooth-scroll", "*"))
        implementation("io.kvision:kvision:$kvisionVersion")
        implementation("io.kvision:kvision-fontawesome:$kvisionVersion")
        implementation("io.kvision:kvision-jquery:$kvisionVersion")
    }
    sourceSets["jsTest"].dependencies {
        implementation(kotlin("test-js"))
    }
}

afterEvaluate {
    tasks {
        create("dist", Copy::class) {
            dependsOn("jsBrowserProductionWebpack")
            group = "package"
            destinationDir = file("$buildDir/app")
            val distribution =
                project.tasks.getByName("jsBrowserProductionWebpack", KotlinWebpack::class).outputDirectory
            from(distribution) {
                include("*.*")
            }
            val processedResources =
                project.tasks.getByName("jsProcessResources", Copy::class).destinationDir
            from(processedResources)
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            inputs.files(distribution, processedResources)
            outputs.dirs(destinationDir)
        }
    }
}
