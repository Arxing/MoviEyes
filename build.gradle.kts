// Top-level build file where you can add configuration options common to all sub-projects/modules.
@file:Suppress("DSL_SCOPE_VIOLATION")

buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies {
    classpath(libs.gradle.android.plugin)
    classpath(libs.gradle.kotlin.plugin)
    classpath(libs.gradle.hilt.plugin)
  }
}

plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.hilt) apply false
  alias(libs.plugins.kotlin.jvm) apply false
}
