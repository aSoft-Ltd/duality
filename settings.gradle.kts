pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

rootProject.name = "duality"

include(":either-core")
include(":result-core")

include(":either-test-expect")
project(":either-test-expect").projectDir = File("test/either-test-expect")
include(":result-test-expect")
project(":result-test-expect").projectDir = File("test/result-test-expect")
