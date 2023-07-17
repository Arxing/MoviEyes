plugins {
  id("me.android.library")
  id("com.google.devtools.ksp") version "1.8.22-1.0.11"
  id("me.hilt")
  id("kotlin-parcelize")
}

android {
  namespace = "org.me.core.entity"
}

dependencies {
  implementation(libs.gson)
  implementation(libs.room.runtime)
  implementation(libs.room.ktx)
  ksp(libs.room.compiler)
  implementation(project(":core:network"))
}
