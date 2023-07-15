plugins {
  id("me.android.library")
  id("me.compose")
  id("me.hilt")
}

android {
  namespace = "org.me.core.shared"
}

dependencies {
  implementation(libs.androidx.fragment)
}
