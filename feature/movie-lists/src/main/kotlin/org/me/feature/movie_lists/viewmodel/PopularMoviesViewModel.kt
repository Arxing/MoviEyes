package org.me.feature.movie_lists.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.me.core.data.usecase.ChangeFavorite
import org.me.core.data.usecase.ObserveFavorites
import org.me.feature.movie_lists.PopularMoviesPagingSource
import org.me.feature.movie_lists.data.MovieCardState
import org.me.feature.movie_lists.mapping.MovieMapping
import javax.inject.Inject

@HiltViewModel
internal class PopularMoviesViewModel @Inject constructor(
  private val movieMapping: MovieMapping,
  private val popularMoviesPagingSource: PopularMoviesPagingSource,
  private val changeFavorite: ChangeFavorite,
  private val observeFavorites: ObserveFavorites,
) : ViewModel(), MovieMapping by movieMapping {
  private val _events = MutableSharedFlow<Event>()
  val events: SharedFlow<Event> = _events.asSharedFlow()
  private val _favoriteIds = MutableStateFlow(intArrayOf())
  val favoriteIds: StateFlow<IntArray> = _favoriteIds.asStateFlow()

  init {
    viewModelScope.launch(Dispatchers.IO) {
      launch {
        observeFavorites().collect { favoriteMovieDTOList ->
          _favoriteIds.emit(favoriteMovieDTOList.map { it.movieId }.toIntArray())
        }
      }
    }
  }

  fun getPopularMoviesFlow(): Flow<PagingData<MovieCardState>> {
    return Pager(
      config = PagingConfig(pageSize = 10),
      pagingSourceFactory = { popularMoviesPagingSource },
    ).flow.cachedIn(viewModelScope)
  }

  fun toggleFavorite(card: MovieCardState) {
    viewModelScope.launch(Dispatchers.Default) {
      changeFavorite(card.toFavoriteMovieDTO(), card.movieId !in favoriteIds.value)
    }
  }

  sealed class Event

  data class OnError(val message: String) : Event()
}
