plugins {
  id("me.android.library")
  id("me.compose")
  id("me.hilt")
  id("kotlin-parcelize")
}

android {
  namespace = "org.me.feature.account"
}

dependencies {
  implementation(project(":core:data"))
  implementation(project(":core:shared"))
}
