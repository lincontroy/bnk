@Suppress("DSL_SCOPE_VIOLATION") // TODO: Rem
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.library.compose)
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "com.vunatec.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

}

dependencies {
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.dataStore.core)
    api(libs.bundles.accompanist)
    api(libs.datastore)

    implementation(libs.coil.compose)
    testImplementation(libs.androidx.compose.ui.test)
    testImplementation(libs.accompanist.testharness)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.robolectric)
    androidTestImplementation(libs.androidx.compose.ui.test)

}