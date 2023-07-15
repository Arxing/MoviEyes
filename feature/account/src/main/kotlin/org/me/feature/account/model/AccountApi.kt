package org.me.feature.account.model

import org.me.core.model.AddFavoriteEntity
import org.me.core.model.AddFavoritePayloadEntity
import org.me.core.model.GetFavoriteMoviesEntity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AccountApi {

  @POST("account/{account_id}/favorite")
  suspend fun addFavorite(
    @Path("account_id") accountId: Int,
    @Query("session_id") sessionId: String?,
    @Body payload: AddFavoritePayloadEntity,
  ) : AddFavoriteEntity

  @GET("account/{account_id}/favorite/movies")
  suspend fun getFavoriteMovies(
    @Path("account_id") accountId: Int,
    @Query("language") language: String?,
    @Query("page") page: Int?,
    @Query("session_id") sessionId: String?,
    @Query("sort_by") sortBy: String?,
  ): GetFavoriteMoviesEntity
}
