package org.me.feature.movie_lists.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MovieDetailScreenState(
  val coverUrl: String = "",
  val backdropUrl: String = "",
  val title: String = "",
  val overview: String = "",
  val releaseDate: String = "",
  val genres: List<String> = emptyList(),
  val voteAverage: Float = 0f,
  initIsFavorite: Boolean = false,
) {
  var isFavorite: Boolean by mutableStateOf(initIsFavorite)
}
