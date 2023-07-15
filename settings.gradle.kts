pluginManagement {
  includeBuild("pre-build")
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "MoviEyes"
include(
  ":app",
  ":core:shared",
  ":core:network",
  ":core:entity",
)
