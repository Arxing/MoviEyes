package org.me.feature.account.mapping

import org.me.core.model.AddFavoriteEntity
import org.me.core.model.AddFavoritePayloadEntity
import org.me.core.model.GetFavoriteMoviesEntity
import org.me.core.model.GetFavoriteMoviesEntity.ResultEntity
import org.me.feature.account.data.AddFavoriteDTO
import org.me.feature.account.data.GetFavoriteMoviesDTO
import org.me.feature.account.data.GetFavoriteMoviesDTO.ResultDTO
import javax.inject.Inject

internal class FavoriteMappingImpl @Inject constructor() : FavoriteMapping {

  override fun AddFavoriteEntity.toAddFavoriteDTO(): AddFavoriteDTO {
    return AddFavoriteDTO(success, statusCode, statusMessage)
  }

  override fun GetFavoriteMoviesEntity.toGetFavoriteMoviesDTO(): GetFavoriteMoviesDTO {
    return GetFavoriteMoviesDTO(
      page = page,
      results = results.map { it.toResultDTO() },
      totalPages = totalPages,
      totalResults = totalResults,
    )
  }

  override fun ResultEntity.toResultDTO(): ResultDTO {
    return ResultDTO(
      adult = adult,
      backdropPath = backdropPath,
      genreIds = genreIds,
      id = id,
      originalLanguage = originalLanguage,
      originalTitle = originalTitle,
      overview = overview,
      popularity = popularity,
      posterPath = posterPath,
      releaseDate = releaseDate,
      title = title,
      video = video,
      voteAverage = voteAverage,
      voteCount = voteCount,
    )
  }
}
