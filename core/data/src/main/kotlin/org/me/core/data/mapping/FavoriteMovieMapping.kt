package org.me.core.data.mapping

import org.me.core.data.dto.FavoriteMovieDTO
import org.me.core.data.entity.FavoriteMovieEntity
import javax.inject.Inject

interface FavoriteMovieMapping {

  fun FavoriteMovieEntity.toFavoriteMovieDTO(): FavoriteMovieDTO

  fun FavoriteMovieDTO.toFavoriteMovieEntity(): FavoriteMovieEntity

  class Impl @Inject constructor() : FavoriteMovieMapping {

    override fun FavoriteMovieEntity.toFavoriteMovieDTO(): FavoriteMovieDTO {
      return FavoriteMovieDTO(
        movieId = movieId,
        coverUrl = coverUrl,
        title = title,
        releaseDate = releaseDate,
        overview = overview,
      )
    }

    override fun FavoriteMovieDTO.toFavoriteMovieEntity(): FavoriteMovieEntity {
      return FavoriteMovieEntity(
        movieId = movieId,
        coverUrl = coverUrl,
        title = title,
        releaseDate = releaseDate,
        overview = overview,
      )
    }
  }
}
