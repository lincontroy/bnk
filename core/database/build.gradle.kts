@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.room)
}

android {
    namespace = "com.chachadeveloper.mylibrary"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



}

dependencies {

    api(libs.kotlinx.datetime)
    testImplementation(libs.test.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    testImplementation(libs.kotlinx.coroutines.test)
}