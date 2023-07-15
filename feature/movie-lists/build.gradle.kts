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
  implementation(libs.coil.bom)
  implementation(libs.coil.compose)
  implementation(libs.androidx.paging.compose)
  implementation(project(":core:network"))
  implementation(project(":core:entity"))
  implementation(project(":core:shared"))
}
