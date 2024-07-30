@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.library.compose)
}

android {
    namespace = "com.dev.chacha.home"


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
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            pickFirsts.add("META-INF/io.netty.versions.properties")
        }
    }


}

dependencies {
    implementation(projects.domain)
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)
    implementation(projects.core.util)
    implementation(projects.data)
    implementation(projects.core.database)
    implementation(projects.core.network)
    implementation(projects.core.resources)

    implementation(platform(libs.compose.bom))
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    implementation(libs.accompanist.navigation)
    implementation(libs.biometric)
    implementation(libs.bundles.lifecycle)
    implementation(libs.datastore)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.accompanist)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.timber)
    implementation(libs.kotlin.coroutines.play.services)
    implementation(libs.gms.play.services.auth)
    implementation(libs.lottie.compose)
    implementation(libs.gson.gson)
    implementation(libs.coil.compose)
    implementation(libs.coil.gf)
    implementation(libs.timber)
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