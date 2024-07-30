@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.library.compose)
    alias(libs.plugins.equitymobile.android.application.firebase)
    alias(libs.plugins.kotlin.serialization)
    id("io.realm.kotlin")
}


android {
    namespace = "com.dev.chacha.data"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        freeCompilerArgs + "-Xjvm-default=all"
        jvmTarget = "1.8"

    }

}

dependencies {
    implementation(projects.domain)
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.bundles.ktor)
    implementation(libs.timber)
    implementation(libs.bundles.firebase)
    implementation(libs.datastore)
    implementation(libs.realm.library.base)
    implementation(libs.bundles.koin)
    implementation(libs.gms.play.services.auth)
    implementation(libs.gms.play.phone.auth)
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

