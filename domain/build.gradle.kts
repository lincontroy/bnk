@file:Suppress("unused")
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.library.compose)
    alias(libs.plugins.equitymobile.android.application.firebase)

}

android {
    namespace = "com.dev.chacha.domain"
}


dependencies {
    implementation(libs.bundles.firebase)
    implementation(libs.kotlinx.coroutines.core)
}