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
val kvisionVersion: String by System.getProperties()

kotlin {
    js {
        browser {
            useEsModules()
            runTask {
                mainOutputFileName = "main.bundle.js"
                sourceMaps = false
            }
            webpackTask {
                mainOutputFileName = "main.bundle.js"
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
        binaries.executable()
        compilerOptions {
            target.set("es2015")
        }
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
