package org.me.feature.account.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.me.core.data.usecase.DeleteFavorite
import org.me.core.data.usecase.ObserveFavorites
import org.me.feature.account.data.FavoriteMovieCardState
import org.me.feature.account.mapping.FavoriteMovieMapping
import javax.inject.Inject

@HiltViewModel
class FavoriteMoviesViewModel @Inject constructor(
  private val observeFavorites: ObserveFavorites,
  private val favoriteMovieMapping: FavoriteMovieMapping,
  private val deleteFavorite: DeleteFavorite,
) : ViewModel(), FavoriteMovieMapping by favoriteMovieMapping {
  private val _movieCards = MutableStateFlow<List<FavoriteMovieCardState>>(emptyList())
  val movieCards: StateFlow<List<FavoriteMovieCardState>> = _movieCards.asStateFlow()

  init {
    viewModelScope.launch(Dispatchers.IO) {
      launch {
        observeFavorites().collect { favoriteMovieDTOList ->
          _movieCards.emit(favoriteMovieDTOList.map { it.toFavoriteMovieCardState() })
        }
      }
    }
  }

  fun deleteFavorite(card: FavoriteMovieCardState) {
    viewModelScope.launch(Dispatchers.IO) {
      deleteFavorite(card.movieId)
    }
  }
}
