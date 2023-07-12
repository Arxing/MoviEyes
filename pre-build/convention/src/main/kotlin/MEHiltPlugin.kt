import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class MEHiltPlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      plugins {
        apply("com.google.dagger.hilt.android")
        apply("org.jetbrains.kotlin.kapt")
      }

      dependencies {
        implementation(libs.library("hilt.android"))
        kapt(libs.library("hilt.compiler"))
      }
    }
  }
}
