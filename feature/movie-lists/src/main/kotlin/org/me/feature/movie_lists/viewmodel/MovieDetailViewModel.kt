package org.me.feature.movie_lists.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import org.me.feature.movie_lists.data.MovieDetailScreenState
import org.me.feature.movie_lists.mapping.MovieDetailMapping
import org.me.feature.movie_lists.usecase.GetMovieDetail
import javax.inject.Inject

@HiltViewModel
internal class MovieDetailViewModel @Inject constructor(
  private val getMovieDetail: GetMovieDetail,
  private val movieDetailMapping: MovieDetailMapping,
) : ViewModel(), MovieDetailMapping by movieDetailMapping {
  var screen: MovieDetailScreenState by mutableStateOf(MovieDetailScreenState())

  private val _events = MutableSharedFlow<Event>()
  val events: SharedFlow<Event> = _events.asSharedFlow()

  fun fetchMovie(movieId: Int) {
    viewModelScope.launch {
      kotlin.runCatching {
        getMovieDetail(movieId)
      }.onSuccess {
        screen = it.toMovieDetailScreenState()
      }.onFailure {
        _events.emit(OnError("Fetch movie error: ${it.message}"))
      }
    }
  }

  sealed class Event

  data class OnError(val message: String) : Event()
}
