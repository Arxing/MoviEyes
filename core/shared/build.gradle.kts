plugins {
  id("me.android.library")
  id("me.compose")
  id("me.hilt")
}

android {
  namespace = "org.me.core.shared"
}

dependencies {
  api(libs.androidx.fragment)
  api(libs.androidx.fragmentKtx)
}
