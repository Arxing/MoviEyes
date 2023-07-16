package org.me.feature.movie_lists.mapping

import org.me.core.model.GetMovieDetailEntity
import org.me.core.model.GetMovieDetailEntity.GenreEntity
import org.me.core.network.ImageUrlGenerator
import org.me.feature.movie_lists.data.GetMovieDetailDTO
import org.me.feature.movie_lists.data.GetMovieDetailDTO.GenreDTO
import org.me.feature.movie_lists.data.MovieDetailScreenState
import javax.inject.Inject

internal class MovieDetailMappingImpl @Inject constructor(
  private val imageUrlGenerator: ImageUrlGenerator,
) : MovieDetailMapping {

  override fun GenreEntity.toGenreDTO(): GenreDTO {
    return GenreDTO(id, name)
  }

  override fun GetMovieDetailEntity.toGetMovieDetailDTO(): GetMovieDetailDTO {
    return GetMovieDetailDTO(
      adult,
      backdropPath,
      budget,
      genres.map { it.toGenreDTO() },
      homepage,
      id,
      imdbId,
      originalLanguage,
      originalTitle,
      overview,
      popularity,
      posterPath,
      releaseDate,
      revenue,
      runtime,
      status,
      tagline,
      title,
      video,
      voteAverage,
      voteCount,
    )
  }

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
