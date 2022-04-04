object Configs {
    const val compileSdkVersion = 32
    const val minSdkVersion = 21
    const val targetSdkVersion = 32

    const val versionCode = 1
    const val versionName = "1.0"
}

object Core {
    private const val androidxCoreVersion = "1.7.0"
    private const val appCompatVersion = "1.3.0"
    private const val materialVersion = "1.4.0"
    private const val constraintLayoutVersion = "2.0.4"
    private const val dynamicAnimationVersion = "1.1.0-alpha03"

    const val androidXCore = "androidx.core:core-ktx:$androidxCoreVersion"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    const val material = "com.google.android.material:material:$materialVersion"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    const val dynamicAnimation = "androidx.dynamicanimation:dynamicanimation:$dynamicAnimationVersion"
}

object Tests {
    private const val junitVersion = "4.13.2"
    private const val androidXJunitVersion = "1.1.3"
    private const val espressoVersion = "3.4.0"

    const val junit = "junit:junit:$junitVersion"
    const val androidXJunit = "androidx.test.ext:junit:${androidXJunitVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
}