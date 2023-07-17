package org.me.core.data.repository

import org.me.core.data.entity.GetMovieDetailEntity
import org.me.core.data.entity.GetPopularMoviesEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface MovieListsApi {

  @GET("3/movie/popular")
  suspend fun getPopularMovies(
    @Query("language") language: String?,
    @Query("page") page: Int?,
    @Query("sort_by") sortBy: String?,
  ): GetPopularMoviesEntity

  @GET("3/movie/{movie_id}")
  suspend fun getMovieDetail(@Path("movie_id") movieId: Int, @Query("language") language: String?): GetMovieDetailEntity
}
