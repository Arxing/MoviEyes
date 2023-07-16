package org.me.feature.movie_lists.mapping

import org.me.core.network.ImageUrlGenerator
import org.me.feature.movie_lists.data.GetPopularMoviesDTO.ResultDTO
import org.me.feature.movie_lists.data.MovieCardState
import org.me.feature.movie_lists.data.MovieDTO
import javax.inject.Inject

internal class MovieMappingImpl @Inject constructor(
  private val imageUrlGenerator: ImageUrlGenerator,
) : MovieMapping {

  override fun ResultDTO.toMovieDTO(): MovieDTO {
    return MovieDTO(
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

  override fun MovieDTO.toMovieCardState(): MovieCardState {
    return MovieCardState(
      movieId = id,
      coverUrl = imageUrlGenerator.generateImageUrl(posterPath),
      title = title,
      releaseDate = releaseDate,
      overview = overview,
      initIsFavorite = false,
    )
  }
}
