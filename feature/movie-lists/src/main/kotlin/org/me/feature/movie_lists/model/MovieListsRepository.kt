package org.me.feature.movie_lists.model

import org.me.feature.movie_lists.data.GetPopularMoviesDTO

interface MovieListsRepository {

  suspend fun getPopularMovies(
    language: String?,
    page: Int?,
    sortBy: String?,
  ): GetPopularMoviesDTO
}
