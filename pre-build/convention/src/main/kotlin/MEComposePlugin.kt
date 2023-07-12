import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class MEComposePlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      android {
        buildFeatures {
          compose = true
        }

        composeOptions {
          kotlinCompilerExtensionVersion = libs.version("androidxComposeCompiler")
        }

        dependencies {
          val composeBom = platform(libs.library("compose.bom"))
          implementation(composeBom)
          implementation(libs.library("androidx.activity.compose"))
          implementation(libs.library("compose.ui"))
          implementation(libs.library("compose.material"))
          implementation(libs.library("compose.uiToolingPreview"))
        }
      }
    }
  }
}
