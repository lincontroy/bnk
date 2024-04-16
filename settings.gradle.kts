@file:Suppress("UnstableApiUsage")
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "EquityMobile"
include(":app")
include (":feature:auth")
include (":feature:transaction")
include (":feature:loans")
include (":feature:home")
include (":feature:savings")
include (":data")
include (":domain")
include(":core:ui")
include(":core:util")
include(":feature:settings")
include(":feature:onboarding")
include(":core:designsystem")
include(":core:database")
include(":core:network")
