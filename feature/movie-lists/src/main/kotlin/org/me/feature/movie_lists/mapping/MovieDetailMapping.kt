package org.me.feature.movie_lists.mapping

import org.me.core.data.dto.GetMovieDetailDTO
import org.me.core.network.ImageUrlGenerator
import org.me.feature.movie_lists.data.MovieDetailScreenState
import javax.inject.Inject

interface MovieDetailMapping {

  fun GetMovieDetailDTO.toMovieDetailScreenState(): MovieDetailScreenState

  class Impl @Inject constructor(
    private val imageUrlGenerator: ImageUrlGenerator,
  ) : MovieDetailMapping {

    override fun GetMovieDetailDTO.toMovieDetailScreenState(): MovieDetailScreenState {
      return MovieDetailScreenState(
        coverUrl = imageUrlGenerator.generateImageUrl(posterPath),
        backdropUrl = imageUrlGenerator.generateImageUrl(backdropPath),
        title = title,
        releaseDate = releaseDate,
        overview = overview,
        genres = genres.map { it.name },
        voteAverage = voteAverage.div(10).toFloat(),
        initIsFavorite = false,
      )
    }
  }
}
