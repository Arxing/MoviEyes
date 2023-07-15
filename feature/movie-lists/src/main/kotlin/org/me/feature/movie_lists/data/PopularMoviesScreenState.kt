package org.me.feature.movie_lists.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PopularMoviesScreenState(
  initMovieCards: List<MovieCardState>,
) {
  var movieCards: List<MovieCardState> by mutableStateOf(initMovieCards)

  fun appendMovieCards(append: List<MovieCardState>) {
    movieCards = movieCards + append
  }

  companion object {

    val empty: PopularMoviesScreenState = PopularMoviesScreenState(emptyList())
  }
}
