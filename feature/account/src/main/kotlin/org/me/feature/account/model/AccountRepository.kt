package org.me.feature.account.model

import org.me.feature.account.data.AddFavoriteDTO
import org.me.feature.account.data.GetFavoriteMoviesDTO

interface AccountRepository {

  suspend fun addFavorite(
    accountId: Int,
    sessionId: String?,
    mediaType: String,
    mediaId: Int,
    favorite: Boolean,
  ) : AddFavoriteDTO

  suspend fun getFavoriteMovies(
    accountId: Int,
    language: String?,
    page: Int?,
    sessionId: String?,
    sortBy: String?,
  ): GetFavoriteMoviesDTO
}
