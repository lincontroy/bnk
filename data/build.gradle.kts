plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("org.jlleitschuh.gradle.ktlint")
    id("io.gitlab.arturbosch.detekt")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.dev.chacha.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        if (File("api_key.txt").exists()) {
            buildConfigField("String", "API_KEY", "\"${File("api_key.txt").readText().trim()}\"")
        } else {
            buildConfigField("String", "API_KEY", "\"\"")
        }
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(Modules.domain))
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    api(libs.kotlin.coroutines.datetime)
    implementation(libs.android.hilt)
    implementation(libs.timber)
    kapt(libs.android.hilt.compiler)
    implementation(libs.datastore)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.ktor.core)
    implementation(libs.ktor.android)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.json)
    implementation(libs.ktor.auth)
    implementation(libs.ktor.logging)

    androidTestImplementation(libs.android.test.junit4)
    androidTestImplementation(libs.android.test.espresso)

    testImplementation(libs.test.junit.ktx)
    testImplementation(libs.test.junit4)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.test.androidx.core)
    testImplementation(libs.test.robolectric)
    testImplementation(libs.ktor.mock)
    testImplementation(libs.test.mockk)
}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }
    }
}

