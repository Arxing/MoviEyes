package org.me.core.data.repository.impl

import org.me.core.data.dto.GetMovieDetailDTO
import org.me.core.data.dto.GetPopularMoviesDTO
import org.me.core.data.mapping.MovieDetailDataMapping
import org.me.core.data.mapping.PopularMoviesDataMapping
import org.me.core.data.repository.MovieListsApi
import org.me.core.data.repository.MovieListsRepository
import javax.inject.Inject

internal class MovieListsRepositoryImpl @Inject constructor(
  private val api: MovieListsApi,
  private val popularMoviesMapping: PopularMoviesDataMapping,
  private val movieDetailMapping: MovieDetailDataMapping,
) : MovieListsRepository, PopularMoviesDataMapping by popularMoviesMapping, MovieDetailDataMapping by movieDetailMapping {

  override suspend fun getPopularMovies(
    language: String?,
    page: Int?,
    sortBy: String?,
  ): GetPopularMoviesDTO {
    return api.getPopularMovies(language, page, sortBy).toGetPopularMoviesDTO()
  }

  override suspend fun getMovieDetail(movieId: Int, language: String?): GetMovieDetailDTO {
    return api.getMovieDetail(movieId, language).toGetMovieDetailDTO()
  }
}
