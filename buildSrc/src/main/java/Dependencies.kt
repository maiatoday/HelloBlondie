object Versions {
    val gradlePluginVersion = "3.2.0-alpha09"
    val apolloVersion = "0.4.4"

    val okhttpVersion =   "3.9.0"
    val retrofitVersion = "2.3.0"
    val supportLibVersion =  "27.1.0"
    val kotlinVersion =  "1.2.31"
    val ktxVersion = "0.1"
    val constraintLayoutVersion =  "1.0.2"

    val junitVersion = "4.12"
    val testRunnerVersion = "1.0.1"
    val espressoVersion = "3.0.1"
}

object Libs {
    // plugins
    val plugin_android_gradle = "com.android.tools.build:gradle:${Versions.gradlePluginVersion}"
    val plugin_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    val plugin_apollo = "com.apollographql.apollo:apollo-gradle-plugin:${Versions.apolloVersion}"

    // kotlin
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlinVersion}"
    val ktx = "androidx.core:core-ktx:${Versions.ktxVersion}"

    //support
    val support_annotations = "com.android.support:support-annotations:${Versions.supportLibVersion}"
    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.supportLibVersion}"
    val support_v13 = "com.android.support:support-v13:${Versions.supportLibVersion}"
    val support_design = "com.android.support:design:${Versions.supportLibVersion}"
    val support_constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayoutVersion}"

    // retrofit
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    //other
    val apollo_runtime = "com.apollographql.apollo:apollo-runtime:${Versions.apolloVersion}"

    // testing
    val junit =  "junit:junit:${Versions.junitVersion}"
    val test_runner =  "com.android.support.test:runner:${Versions.testRunnerVersion}"
    val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espressoVersion}"
}