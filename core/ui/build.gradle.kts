@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.library.compose)
}


android {
    namespace = "com.dev.chacha.ui"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }


    packaging {
        resources {
            exclude("META-INF/INDEX.LIST")
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            pickFirsts.add("META-INF/io.netty.versions.properties")
        }
    }

}

dependencies {
    implementation(projects.core.designsystem)
    api(libs.android.appCompat)
    api(libs.android.material)
    api(libs.bundles.accompanist)
    api(libs.androidx.dataStore.core)
    api(libs.datastore)
    api(libs.androidx.lifecycle.runtimeKtx)
    api(libs.timber)
    implementation(libs.coil.gf)
    api(libs.androidx.splashscreen)
    api(libs.kotlin.coroutines.play.services)
    api(libs.gms.play.services.auth)
    api(libs.lottie.compose)
    api(libs.accompanist.swiperefresh)
    api(libs.kotlinx.datetime)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)


    androidTestImplementation(libs.android.test.junit4)
    androidTestImplementation(libs.android.test.espresso)
    androidTestImplementation(libs.compose.ui.test.junit)

    testImplementation(libs.test.junit4)
    testImplementation(libs.compose.ui.test.junit)
    testImplementation(libs.android.test.espresso)
    testImplementation(libs.test.mockk)

}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
            }
        }
    }
}