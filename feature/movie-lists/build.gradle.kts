plugins {
  id("me.android.library")
  id("me.compose")
  id("me.hilt")
  id("kotlin-parcelize")
}

android {
  namespace = "org.me.feature.movie_lists"
}

dependencies {
  implementation(libs.retrofit.core)
  implementation(project(":core:network"))
  implementation(project(":core:entity"))
  implementation(project(":core:shared"))
}
