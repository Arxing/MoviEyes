package org.me.core.shared.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun METheme(content: @Composable () -> Unit) {
  MaterialTheme(
    colors = MEColors(),
  ) {
    content()
  }
}
