import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class MEAndroidLibraryPlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      plugins {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
      }

      androidLibrary {
        compileSdk = libs.version("compileSdkVersion").toInt()

        defaultConfig {
          targetSdk = libs.version("targetSdkVersion").toInt()
          minSdk = libs.version("minSdkVersion").toInt()
        }

        val javaVersion = libs.version("java")

        compileOptions {
          sourceCompatibility = JavaVersion.toVersion(javaVersion)
          targetCompatibility = JavaVersion.toVersion(javaVersion)
        }

        kotlinOptions {
          jvmTarget = JavaVersion.toVersion(javaVersion).toString()
        }
      }
    }
  }
}
