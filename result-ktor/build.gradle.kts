plugins {
    kotlin("jvm")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    target { library() }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":result-core"))
                api("io.ktor:ktor-server-core:${vers.ktor}")
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.duality,
    description = "A Ktor way to send back results to clients"
)