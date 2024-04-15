@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.library)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.library.compose)
}



android {
    namespace = "com.dev.chacha.common"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }



}

dependencies {

    implementation(project(Modules.ui))
    implementation(project(Modules.util))


    implementation(project(Modules.home))
    implementation(project(Modules.transaction))
    implementation(project(Modules.more))
    implementation(project(Modules.savings))
    implementation(project(Modules.loans))
    implementation(project(Modules.auth))


//    implementation(project(Modules.data))
    implementation(project(Modules.domain))
//    implementation(project(Modules.coreNetwork))
    implementation(project(Modules.coreDatabase))


    api(libs.android.appCompat)
    api(libs.android.material)
    api(libs.android.material)
    api(libs.androidx.lifecycle.runtimeKtx)
    api(libs.timber)
    api(libs.androidx.splashscreen)
    api(libs.kotlin.coroutines.play.services)
    api(libs.gms.play.services.auth)
    api(libs.lottie.compose)
    api(libs.accompanist.swiperefresh)
    api(libs.kotlinx.datetime)
    api(libs.firebase.cloud.messaging)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)


    androidTestImplementation(libs.android.test.junit4)
    androidTestImplementation(libs.android.test.espresso)
    androidTestImplementation(libs.compose.ui.test.junit)

    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)

    

    implementation(libs.timber)
    androidTestImplementation(libs.android.test.junit4)
    androidTestImplementation(libs.android.test.espresso)
    testImplementation(libs.test.junit4)
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