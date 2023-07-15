import java.util.Properties
import kotlin.properties.ReadOnlyProperty

plugins {
  id("me.android.library")
  id("me.hilt")
}

android {
  namespace = "org.me.core.network"

  defaultConfig {
    val props = Properties().also { it.load(rootProject.file("local.properties").inputStream()) }
    val apiKey = props.getProperty("tmdb.apiKey") ?: System.getenv("tmdb.apiKey")
    val accessToken = props.getProperty("tmdb.accessToken") ?: System.getenv("tmdb.accessToken")

    buildConfigField("String", "TMDB_API_KEY", "\"$apiKey\"")
    buildConfigField("String", "TMDB_ACCESS_TOKEN", "\"$accessToken\"")
  }
}

dependencies {
  implementation(libs.retrofit.core)
  implementation(libs.retrofit.converter.gson)
}
