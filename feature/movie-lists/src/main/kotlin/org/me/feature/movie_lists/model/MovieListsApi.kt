package org.me.feature.movie_lists.model

import org.me.core.model.GetPopularMoviesEntity
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieListsApi {

  @GET("movie/popular")
  suspend fun getPopularMovies(
    @Query("language") language: String?,
    @Query("page") page: Int?,
    @Query("sort_by") sortBy: String?,
  ): GetPopularMoviesEntity
}
