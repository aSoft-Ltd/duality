plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    universalLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlinx("serialization-json",vers.kotlinx.serialization))
            }
        }

        val commonTest by getting {
            dependencies {
                api(asoft("test-core", vers.asoft.test))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.duality,
    description = "An Either<L,R> multiplatform serializable datatype"
)