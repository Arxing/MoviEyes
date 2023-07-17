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
  implementation(libs.coil.bom)
  implementation(libs.coil.compose)
  implementation(project(":core:data"))
  implementation(project(":core:shared"))
  implementation(project(":feature:movie-lists"))
}
