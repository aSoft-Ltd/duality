plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    val darwinTargets = listOf(
        watchosArm64(),
        watchosArm32(),
        watchosX86(),
        macosX64(),
        iosArm64(),
        iosArm32(),
        iosX64(),
        tvosArm64(),
        tvosX64()
    )

    val linuxTargets = listOf(
        linuxArm32Hfp(),
        linuxArm64(),
        linuxX64(),
    )
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":either-core"))
                api(asoft("expect-core", vers.asoft.expect))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.duality,
    description = "An multiplatform extension for asserting Either<L,R> datatypes"
)