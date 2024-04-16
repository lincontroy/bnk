@file:Suppress("unused")
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.library.compose)


}

android {
    namespace = "com.dev.chacha.domain"
}


dependencies {
    implementation(libs.kotlinx.coroutines.core)
}