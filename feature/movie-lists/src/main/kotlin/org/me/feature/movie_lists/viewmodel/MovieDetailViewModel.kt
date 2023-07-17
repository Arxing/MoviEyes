package org.me.feature.movie_lists.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import org.me.core.data.dto.FavoriteMovieDTO
import org.me.core.data.usecase.ChangeFavorite
import org.me.core.data.usecase.GetMovieDetail
import org.me.core.data.usecase.ObserveIsInFavorites
import org.me.feature.movie_lists.data.MovieDetailScreenState
import org.me.feature.movie_lists.mapping.MovieDetailMapping
import org.me.feature.movie_lists.ui.MovieDetailFragment
import javax.inject.Inject

@HiltViewModel
internal class MovieDetailViewModel @Inject constructor(
  private val getMovieDetail: GetMovieDetail,
  private val movieDetailMapping: MovieDetailMapping,
  private val observeIsInFavorites: ObserveIsInFavorites,
  private val changeFavorite: ChangeFavorite,
  savedStateHandle: SavedStateHandle,
) : ViewModel(), MovieDetailMapping by movieDetailMapping {
  var screen: MovieDetailScreenState by mutableStateOf(MovieDetailScreenState())

  private val _events = MutableSharedFlow<Event>()
  val events: SharedFlow<Event> = _events.asSharedFlow()
  private var _isFavorite = mutableStateOf(false)
  val isFavorite: Boolean by _isFavorite

  private val movieId = savedStateHandle.get<Int>(MovieDetailFragment.ARGS_MOVIE_ID) ?: error("ARGS_MOVIE_ID is null")

  init {
    viewModelScope.launch(Dispatchers.IO) {
      launch {
        observeIsInFavorites(movieId).collect {
          _isFavorite.value = it
        }
      }
    }
  }

  fun fetchMovie(movieId: Int) {
    viewModelScope.launch {
      kotlin.runCatching {
        getMovieDetail(movieId)
      }.onSuccess {
        screen = it.toMovieDetailScreenState()
      }.onFailure {
        it.printStackTrace()
        _events.emit(OnError("Fetch movie error: ${it.message}"))
      }
    }
  }

  fun toggleFavorite() {
    viewModelScope.launch(Dispatchers.Default) {
      val favoriteMovieDTO = FavoriteMovieDTO(movieId, screen.coverUrl, screen.title)
      changeFavorite(favoriteMovieDTO, !isFavorite)
    }
  }

  sealed class Event

  data class OnError(val message: String) : Event()
}
