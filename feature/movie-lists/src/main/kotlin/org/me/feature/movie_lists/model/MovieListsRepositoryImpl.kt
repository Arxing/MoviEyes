package org.me.feature.movie_lists.model

import org.me.feature.movie_lists.data.GetPopularMoviesDTO
import org.me.feature.movie_lists.mapping.PopularMoviesMapping
import javax.inject.Inject

internal class MovieListsRepositoryImpl @Inject constructor(
  private val api: MovieListsApi,
  private val popularMoviesMapping: PopularMoviesMapping,
) : MovieListsRepository, PopularMoviesMapping by popularMoviesMapping {

  override suspend fun getPopularMovies(
    language: String?,
    page: Int?,
    sortBy: String?,
  ): GetPopularMoviesDTO {
    return api.getPopularMovies(language, page, sortBy).toGetPopularMoviesDTO()
  }
}
