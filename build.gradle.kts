plugins {
    id("com.android.library")
    id ("maven-publish")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}


android {
    namespace = "com.example.androidaarbalasample"
    compileSdk = 35

    defaultConfig {
        minSdk = 28
        targetSdk = 35
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
    implementation("com.example.flutter_new_module:flutter_release:1.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

publishing {
    publications {
        create<MavenPublication>("release") {  // Name of the publication (e.g., "release")
            // Use the AAR generated by the Android library plugin

            groupId = "com.github.SomaPrasanna4037"      // Replace with your GitHub username
            artifactId = "app"      // Suggested artifactId based on your namespace
            version = "1.0.2"
            artifact("$buildDir/outputs/aar/app-release.aar")
        }
    }
}