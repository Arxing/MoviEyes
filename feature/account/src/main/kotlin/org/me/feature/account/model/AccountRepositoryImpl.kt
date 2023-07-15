package org.me.feature.account.model

import org.me.core.model.AddFavoritePayloadEntity
import org.me.feature.account.data.AddFavoriteDTO
import org.me.feature.account.data.GetFavoriteMoviesDTO
import org.me.feature.account.mapping.FavoriteMapping
import javax.inject.Inject

internal class AccountRepositoryImpl @Inject constructor(
  private val api: AccountApi,
  private val favoriteMapping: FavoriteMapping,
) : AccountRepository, FavoriteMapping by favoriteMapping {

  override suspend fun addFavorite(
    accountId: Int,
    sessionId: String?,
    mediaType: String,
    mediaId: Int,
    favorite: Boolean,
  ): AddFavoriteDTO {
    return api.addFavorite(
      accountId = accountId,
      sessionId = sessionId,
      payload = AddFavoritePayloadEntity(mediaType, mediaId, favorite),
    ).toAddFavoriteDTO()
  }

  override suspend fun getFavoriteMovies(
    accountId: Int,
    language: String?,
    page: Int?,
    sessionId: String?,
    sortBy: String?,
  ): GetFavoriteMoviesDTO {
    return api.getFavoriteMovies(accountId, language, page, sessionId, sortBy).toGetFavoriteMoviesDTO()
  }
}
