import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.androidApplication(configure: ApplicationExtension.() -> Unit) {
  (this as ExtensionAware).extensions.configure("android", configure)
}

internal fun Project.androidLibrary(configure: LibraryExtension.() -> Unit) {
  (this as ExtensionAware).extensions.configure("android", configure)
}

internal fun Project.android(configure: CommonExtension<*, *, *, *>.() -> Unit) {
  (this as ExtensionAware).extensions.configure("android", configure)
}

internal fun Project.plugins(configure: PluginManager.() -> Unit) = pluginManager.configure()

internal val Project.libs: VersionCatalog
  get() = (this as ExtensionAware).extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun VersionCatalog.library(alias: String): Provider<MinimalExternalModuleDependency> = findLibrary(alias).get()

internal fun VersionCatalog.version(alias: String): String = findVersion(alias).get().requiredVersion

internal fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
  (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}

internal fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
  add("implementation", dependencyNotation)
}

internal fun DependencyHandlerScope.kapt(dependencyNotation: Any) {
  add("kapt", dependencyNotation)
}
