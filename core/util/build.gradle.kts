@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.library.compose)
    alias(libs.plugins.parcelize)
}

android {
    namespace = "com.dev.chacha.util"

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

}

dependencies {
    implementation(projects.core.designsystem)
    implementation(platform(libs.compose.bom))
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    implementation(libs.biometric)
    implementation(libs.bundles.lifecycle)
    implementation(libs.datastore)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)
    implementation(libs.bundles.accompanist)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.timber)
    implementation(libs.kotlin.coroutines.play.services)
    implementation(libs.kotlinx.datetime)
    implementation(libs.lottie.compose)
    implementation(libs.gson.gson)
    implementation(libs.coil.compose)
    implementation(libs.coil.kt.svg)
    implementation(libs.coil.gf)
    implementation(libs.timber)
    implementation(libs.accompanist.swiperefresh)
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