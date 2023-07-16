package org.me.core.shared.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import org.me.core.shared.R

@Composable
fun MEColors() : Colors {
  val primary = colorResource(id = R.color.colorPrimary)
  val primaryVariant = colorResource(id = R.color.colorPrimaryVariant)
  val onPrimary = colorResource(id = R.color.colorOnPrimary)

  val secondary = colorResource(id = R.color.colorSecondary)
  val secondaryVariant = colorResource(id = R.color.colorSecondaryVariant)
  val onSecondary = colorResource(id = R.color.colorOnSecondary)

  val surface = colorResource(id = R.color.colorSurface)
  val onSurface = colorResource(id = R.color.colorOnSurface)

  val error = colorResource(id = R.color.colorError)
  val onError = colorResource(id = R.color.colorOnError)

  val background = colorResource(id = R.color.colorBackground)
  val onBackground = colorResource(id = R.color.colorOnBackground)

  return remember {
    Colors(
      primary = primary,
      primaryVariant = primaryVariant,
      secondary = secondary,
      secondaryVariant = secondaryVariant,
      onSurface = onSurface,
      error = error,
      background = background,
      surface = surface,
      onPrimary = onPrimary,
      onSecondary = onSecondary,
      onBackground = onBackground,
      onError = onError,
      isLight = true,
    )
  }
}
