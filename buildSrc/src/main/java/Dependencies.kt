object AppMetaData {
    const val id = "com.fpadilha90.movies"
    const val compileSdkVersion = 29
    const val targetSdkVersion = 29
    const val minSdkVersion = 19

    private const val majorVersion = 1
    private const val minorVersion = 0
    private const val patchVersion = 0
    const val versionCode = (majorVersion * 1000000) + (minorVersion * 10000) + (patchVersion * 10)
    const val versionName = "$majorVersion.$minorVersion.$patchVersion"
}

object Versions {
    // Application
    const val kotlin = "1.3.41"
    const val gradle = "3.4.2"

    // Core
    const val androidX = "1.2.0-alpha03"
    const val androidXAnnotation = "1.1.0"
    const val androidXLegacy = "1.0.0"
    const val androidXTest = "1.0.0"
    const val appCompat = "1.1.0-rc01"
    const val lifecycle = "2.2.0-alpha03"
    const val multidex = "1.0.3"
    const val koin = "2.0.1"
    const val coroutines = "1.3.0-M2"
    const val navigation = "1.0.0"
    const val okHttp = "3.12.0"
    const val retrofit = "2.6.0"
    const val room = "2.1.0"
    const val paging = "2.1.0-rc01"
    const val gson = "2.8.5"
    const val rxjava2 = "2.2.4"

    // UI
    const val constraintLayout = "1.1.3"
    const val googleAndroidMaterial = "1.0.0"
    const val recyclerView = "1.1.0-beta03"
    const val glide = "4.9.0"

    // Test
    const val jUnit = "4.12"
    const val testRunner = "1.2.0"
    const val testEspresso = "3.2.0"
    const val roboElectric = "4.3"
    const val truth = "1.0"
}

object Libraries {

    // Core
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidX}"
    const val androidxLegacy =
        "androidx.legacy:legacy-support-core-utils:${Versions.androidXLegacy}"
    const val androidxAnnotation = "androidx.annotation:annotation:${Versions.androidXAnnotation}"
    const val androidxTest = "androidx.test:core:${Versions.androidXTest}"
    const val ktx = "androidx.core:core-ktx:${Versions.androidX}"

    const val multidex = "com.android.support:multidex:${Versions.multidex}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val koinXcore = "org.koin:koin-core:${Versions.koin}"
    const val koinXscope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinXviewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val navigationFragment =
        "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2}"

    const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomRX = "androidx.room:room-rxjava2:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKTX = "androidx.room:room-ktx:${Versions.room}"

    // UI
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val googleAndroidMaterial =
        "com.google.android.material:material:${Versions.googleAndroidMaterial}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"
    const val roboElectric = "org.robolectric:robolectric:${Versions.roboElectric}"
    const val truth = "com.google.truth:truth:${Versions.truth}"

}

object Modules {
    const val app = ":app"
    const val common = ":common"
    const val data = ":data"
    const val home = ":home"
}

object GradleTemplates {
    const val kotlinLibrary = "template-kotlin-library.gradle"
    const val feature = "template-feature.gradle"
}