plugins {
  id("me.android.application")
  id("me.hilt")
  id("me.compose")
}

android {
  namespace = "org.me"

  buildFeatures {
    viewBinding = true
  }

  defaultConfig {
    applicationId = "org.me"
  }
}

dependencies {
  implementation(libs.android.material)
  implementation(libs.androidx.fragment)
  implementation(libs.androidx.fragmentKtx)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)

  implementation(project(":feature:account"))
  implementation(project(":feature:movie-lists"))
  implementation(project(":core:shared"))
}
