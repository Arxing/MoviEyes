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
  implementation(libs.coil.bom)
  implementation(libs.coil.compose)
  implementation(libs.room.runtime)

  implementation(project(":feature:account"))
  implementation(project(":feature:movie-lists"))
  implementation(project(":core:shared"))
  implementation(project(":core:network"))
  implementation(project(":core:data"))
}
