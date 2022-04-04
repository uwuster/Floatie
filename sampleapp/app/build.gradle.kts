plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Configs.compileSdkVersion

    defaultConfig {
        applicationId = "com.uwustor.sampleapp"
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.targetSdkVersion
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Core.androidXCore)
    implementation(Core.appCompat)
    implementation(Core.material)
    implementation(Core.constraintLayout)
    implementation(project(mapOf("path" to ":floatie")))

    testImplementation(Tests.junit)
    androidTestImplementation(Tests.androidXJunit)
    androidTestImplementation(Tests.espresso)
}