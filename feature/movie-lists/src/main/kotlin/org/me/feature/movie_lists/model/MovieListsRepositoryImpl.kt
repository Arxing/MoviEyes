package org.me.feature.movie_lists.model

import org.me.feature.movie_lists.data.GetMovieDetailDTO
import org.me.feature.movie_lists.data.GetPopularMoviesDTO
import org.me.feature.movie_lists.mapping.MovieDetailMapping
import org.me.feature.movie_lists.mapping.PopularMoviesMapping
import javax.inject.Inject

internal class MovieListsRepositoryImpl @Inject constructor(
  private val api: MovieListsApi,
  private val popularMoviesMapping: PopularMoviesMapping,
  private val movieDetailMapping: MovieDetailMapping,
) : MovieListsRepository, PopularMoviesMapping by popularMoviesMapping, MovieDetailMapping by movieDetailMapping {

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
