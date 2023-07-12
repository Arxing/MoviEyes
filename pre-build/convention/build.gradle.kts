plugins {
  `kotlin-dsl`
}

java {
  val java = extensions.getByType<VersionCatalogsExtension>().named("libs").findVersion("java").get().requiredVersion
  sourceCompatibility = JavaVersion.toVersion(java)
  targetCompatibility = JavaVersion.toVersion(java)
}

dependencies {
  compileOnly(libs.gradle.android.plugin)
  compileOnly(libs.gradle.kotlin.plugin)
}

gradlePlugin {
  plugins {
    register("MEAndroidApplication") {
      id = "me.android.application"
      implementationClass = "MEAndroidApplicationPlugin"
    }
    register("MEAndroidLibrary") {""
      id = "me.android.library"
      implementationClass = "MEAndroidLibraryPlugin"
    }
    register("MEHiltPlugin") {
      id = "me.hilt"
      implementationClass = "MEHiltPlugin"
    }
    register("MEComposePlugin") {
      id = "me.compose"
      implementationClass = "MEComposePlugin"
    }
  }
}
