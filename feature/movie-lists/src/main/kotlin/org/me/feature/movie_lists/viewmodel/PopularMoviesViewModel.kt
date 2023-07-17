package org.me.feature.movie_lists.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.me.feature.movie_lists.PopularMoviesPagingSource
import org.me.feature.movie_lists.data.MovieCardState
import org.me.feature.movie_lists.mapping.MovieMapping
import javax.inject.Inject

@HiltViewModel
internal class PopularMoviesViewModel @Inject constructor(
  private val movieMapping: MovieMapping,
  private val popularMoviesPagingSource: PopularMoviesPagingSource,
) : ViewModel(), MovieMapping by movieMapping {
  private val _events = MutableSharedFlow<Event>()
  val events: SharedFlow<Event> = _events.asSharedFlow()

  fun getPopularMoviesFlow(): Flow<PagingData<MovieCardState>> {
    return Pager(
      config = PagingConfig(pageSize = 10),
      pagingSourceFactory = { popularMoviesPagingSource },
    ).flow.cachedIn(viewModelScope)
  }

  sealed class Event

  data class OnError(val message: String) : Event()
}
