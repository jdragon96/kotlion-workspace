///////////////////////////////////////////////////////////////// Project name
rootProject.name = "calculator"

///////////////////////////////////////////////////////////////// Source code path
include(":composeApp")

///////////////////////////////////////////////////////////////// Features
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
//        google {
//            mavenContent {
//                includeGroupAndSubgroups("androidx")
//                includeGroupAndSubgroups("com.android")
//                includeGroupAndSubgroups("com.google")
//            }
//        }
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
//        val agpVersion = extra["agp.version"] as String
//        val composeVersion = extra["compose.version"] as String
//
//        kotlin("jvm").version(kotlinVersion)
//        kotlin("multiplatform").version(kotlinVersion)
//        kotlin("android").version(kotlinVersion)
//        id("com.android.application").version(agpVersion)
//        id("com.android.library").version(agpVersion)
//        id("org.jetbrains.compose").version(composeVersion)
    }
}

//dependencyResolutionManagement {
//    repositories {
//        google {
//            mavenContent {
//                includeGroupAndSubgroups("androidx")
//                includeGroupAndSubgroups("com.android")
//                includeGroupAndSubgroups("com.google")
//            }
//        }
//        mavenCentral()
//    }
//}