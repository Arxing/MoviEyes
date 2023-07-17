package org.me.core.data.repository

import org.me.core.data.dto.GetMovieDetailDTO
import org.me.core.data.dto.GetPopularMoviesDTO

interface MovieListsRepository {

  suspend fun getPopularMovies(
    language: String?,
    page: Int?,
    sortBy: String?,
  ): GetPopularMoviesDTO

  suspend fun getMovieDetail(movieId: Int, language: String?): GetMovieDetailDTO
}
