plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.eventhngs.ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":common"))
    implementation(project(":domain"))

    api("androidx.core:core-ktx:1.12.0")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    api("androidx.appcompat:appcompat:1.6.1")
//    api("com.google.android.material:material:1.10.0")

    api("androidx.activity:activity-compose:1.8.1")
    api(platform("androidx.compose:compose-bom:2023.10.01"))
    api("androidx.compose.ui:ui")
    api("androidx.compose.ui:ui-graphics")
    api("androidx.compose.ui:ui-tooling-preview")
    api("androidx.compose.material:material")
    api("androidx.compose.material3:material3")
    api("androidx.compose.material:material-icons-extended")

    api("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")

    api("io.coil-kt:coil-compose:2.5.0")

    api("com.maxkeppeler.sheets-compose-dialogs:core:1.2.0")

    api("io.insert-koin:koin-bom:3.5.1")
    api("io.insert-koin:koin-core")
    api("io.insert-koin:koin-android")
    api("io.insert-koin:koin-androidx-compose")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

//    implementation("androidx.compose.material:material")

    implementation("androidx.navigation:navigation-compose:2.6.0")
}