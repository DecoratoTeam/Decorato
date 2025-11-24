plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.decorato"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.decorato"
        minSdk = 25
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    navigationDependencies()
    lifeCycleDependencies()
    pagingDependencies()
    kotlinExtensionsDependencies()
    appCompactDependencies()
    previewDependencies()
    composeDependencies()
    uiGraphicsDependencies()
    hiltDependencies()
    kotlinxDateTime()
    splashScreenDependency()
    jsonSerializationDependencies()
}

private fun DependencyHandlerScope.navigationDependencies() {
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.common.android)
}

private fun DependencyHandlerScope.lifeCycleDependencies() {
    implementation(libs.androidx.lifecycle.runtime.ktx)
}


private fun DependencyHandlerScope.pagingDependencies() {
    implementation(libs.androidx.paging.compose)
}

private fun DependencyHandlerScope.kotlinExtensionsDependencies() {
    implementation(libs.androidx.core.ktx)
}

private fun DependencyHandlerScope.appCompactDependencies() {
    implementation(libs.androidx.appcompat)
}

private fun DependencyHandlerScope.previewDependencies() {
    implementation(libs.androidx.ui.tooling.preview.android)
    debugImplementation(libs.androidx.ui.tooling)
}

private fun DependencyHandlerScope.composeDependencies() {
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.ui.graphics.android)
}

private fun DependencyHandlerScope.uiGraphicsDependencies() {
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
}

private fun DependencyHandlerScope.hiltDependencies() {
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation (libs.androidx.hilt.navigation.compose)
}

private fun DependencyHandlerScope.kotlinxDateTime() {
    implementation(libs.kotlinx.datetime)
}


private fun DependencyHandlerScope.splashScreenDependency() {
    implementation(libs.androidx.core.splashscreen)
}

private fun DependencyHandlerScope.jsonSerializationDependencies() {
    implementation(libs.kotlinx.serialization.json)
}
