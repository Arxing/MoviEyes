plugins {
  id("me.android.application")
  id("me.hilt")
  id("me.compose")
}

android {
  namespace = "org.me"

  defaultConfig {
    applicationId = "org.me"
  }
}

dependencies {
  implementation(libs.android.material)
  implementation(libs.androidx.fragment.ktx)
  implementation(libs.androidx.appcompat)
}
