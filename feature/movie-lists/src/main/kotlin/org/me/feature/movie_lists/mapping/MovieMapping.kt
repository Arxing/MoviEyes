package org.me.feature.movie_lists.mapping

import org.me.core.data.dto.FavoriteMovieDTO
import org.me.core.data.dto.MovieDTO
import org.me.core.network.ImageUrlGenerator
import org.me.feature.movie_lists.data.MovieCardState
import javax.inject.Inject

interface MovieMapping {

  fun MovieDTO.toMovieCardState(): MovieCardState

  fun MovieCardState.toFavoriteMovieDTO(): FavoriteMovieDTO

  class Impl @Inject constructor(
    private val imageUrlGenerator: ImageUrlGenerator,
  ) : MovieMapping {

    override fun MovieDTO.toMovieCardState(): MovieCardState {
      return MovieCardState(
        movieId = id,
        coverUrl = posterPath?.let { imageUrlGenerator.generateImageUrl(it) },
        title = title,
        releaseDate = releaseDate,
        overview = overview,
      )
    }

    override fun MovieCardState.toFavoriteMovieDTO(): FavoriteMovieDTO {
      return FavoriteMovieDTO(movieId, coverUrl, title)
    }
  }
}
