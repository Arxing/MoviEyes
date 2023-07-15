import java.util.Properties
import kotlin.properties.ReadOnlyProperty

plugins {
  id("me.android.library")
}

android {
  namespace = "org.me.core.entity"
}

dependencies {
  api(libs.gson)
}
