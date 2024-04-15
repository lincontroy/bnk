@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.equitymobile.android.application)
    alias(libs.plugins.equitymobile.android.application.compose)
    alias(libs.plugins.equitymobile.android.hilt)
    alias(libs.plugins.equitymobile.android.application.firebase)
    kotlin("kapt")
}

android {
    namespace = "com.chachadeveloper.equitymobile"
    
    defaultConfig {
        applicationId = "com.chachadeveloper.equitymobile"

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner= "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary =true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AndroidConfig.javaVersion
        targetCompatibility = AndroidConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AndroidConfig.jvmTarget
    }
    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.kotlinCompilerExtension
    }
    packaging {
        resources {
            pickFirsts.add("META-INF/io.netty.versions.properties")
            pickFirsts.add("META-INF/INDEX.LIST")
        }
    }
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)
    implementation(projects.core.util)
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.coreNetwork)
    implementation(projects.coreDatabase)
    implementation(projects.feature.home)
    implementation(projects.feature.transaction)
    implementation(projects.feature.loans)
    implementation(projects.feature.savings)
    implementation(projects.feature.auth)
    implementation(projects.feature.more)
    implementation(projects.feature.onboarding)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.core.ktx)



    implementation(platform(libs.compose.bom))
    implementation(libs.datastore)
    implementation(libs.androidx.splashscreen)
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    implementation(libs.timber)
    implementation(libs.accompanist.navigation)
    implementation(libs.accompanist.swiperefresh)
    implementation(libs.accompanist.animation)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)
    testImplementation(libs.test.junit4)




}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
                optIn("androidx.compose.material.ExperimentalMaterialApi")
                optIn("androidx.compose.ui.ExperimentalComposeUiApi")
                optIn("androidx.compose.material.ExperimentalMaterialApi")
            }
        }
    }
}