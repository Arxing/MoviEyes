package org.me.feature.movie_lists.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MovieCardState(
  val movieId: Int,
  val coverUrl: String,
  val title: String,
  val releaseDate: String,
  val overview: String,
  initIsFavorite: Boolean,
) {
  var isFavorite: Boolean by mutableStateOf(initIsFavorite)
}
