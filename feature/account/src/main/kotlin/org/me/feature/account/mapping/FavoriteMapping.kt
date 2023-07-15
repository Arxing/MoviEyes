package org.me.feature.account.mapping

import org.me.core.model.AddFavoriteEntity
import org.me.core.model.AddFavoritePayloadEntity
import org.me.core.model.GetFavoriteMoviesEntity
import org.me.feature.account.data.AddFavoriteDTO
import org.me.feature.account.data.GetFavoriteMoviesDTO

interface FavoriteMapping {

  fun AddFavoriteEntity.toAddFavoriteDTO(): AddFavoriteDTO

  fun GetFavoriteMoviesEntity.toGetFavoriteMoviesDTO(): GetFavoriteMoviesDTO

  fun GetFavoriteMoviesEntity.ResultEntity.toResultDTO(): GetFavoriteMoviesDTO.ResultDTO
}
