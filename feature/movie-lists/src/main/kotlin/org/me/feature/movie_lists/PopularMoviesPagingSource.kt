package org.me.feature.movie_lists

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.me.core.data.mapping.MovieDataMapping
import org.me.feature.movie_lists.data.MovieCardState
import org.me.feature.movie_lists.mapping.MovieMapping
import org.me.feature.movie_lists.usecase.GetPopularMovies
import javax.inject.Inject

internal class PopularMoviesPagingSource @Inject constructor(
  private val getPopularMovies: GetPopularMovies,
  private val movieMapping: MovieMapping,
  private val movieDataMapping: MovieDataMapping,
) : PagingSource<Int, MovieCardState>(), MovieMapping by movieMapping, MovieDataMapping by movieDataMapping {

  override fun getRefreshKey(state: PagingState<Int, MovieCardState>): Int? {
    return state.anchorPosition?.let { anchorPosition ->
      state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
        ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
    }
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieCardState> {
    return kotlin.runCatching {
      val page = params.key ?: 1
      val result = getPopularMovies(page = page)

      LoadResult.Page(
        data = result.results.map { it.toMovieDTO().toMovieCardState() },
        prevKey = if (page == 1) null else page.minus(1),
        nextKey = if (page < result.totalPages) page.plus(1) else null,
      )
    }.getOrElse { error ->
      LoadResult.Error(error)
    }
  }
}
