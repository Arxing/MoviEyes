package org.me.core.data.mapping

import org.me.core.data.dto.FavoriteMovieDTO
import org.me.core.data.entity.FavoriteMovieEntity
import javax.inject.Inject

interface FavoriteMovieDataMapping {

  fun FavoriteMovieEntity.toFavoriteMovieDTO(): FavoriteMovieDTO

  fun FavoriteMovieDTO.toFavoriteMovieEntity(): FavoriteMovieEntity

  class Impl @Inject constructor() : FavoriteMovieDataMapping {

    override fun FavoriteMovieEntity.toFavoriteMovieDTO(): FavoriteMovieDTO {
      return FavoriteMovieDTO(
        movieId = movieId,
        coverUrl = coverUrl,
        title = title,
      )
    }

    override fun FavoriteMovieDTO.toFavoriteMovieEntity(): FavoriteMovieEntity {
      return FavoriteMovieEntity(
        movieId = movieId,
        coverUrl = coverUrl,
        title = title,
        modified = System.currentTimeMillis(),
      )
    }
  }
}
