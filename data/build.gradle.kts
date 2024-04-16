@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.library.compose)
    alias(libs.plugins.kotlin.serialization)
}


android {
    namespace = "com.dev.chacha.data"

    defaultConfig {

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
    }

}

dependencies {
    implementation(projects.domain)

    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.bundles.ktor)
    implementation(libs.timber)
    implementation(libs.datastore)
    implementation(libs.gms.play.services.auth)
    implementation(libs.gms.play.phone.auth)
    implementation(libs.firebase.auth)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlin.coroutines.android)
    androidTestImplementation(libs.android.test.junit4)
    androidTestImplementation(libs.android.test.espresso)
    testImplementation(libs.test.junit4)
    testImplementation(libs.test.androidx.core)
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

