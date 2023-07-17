package org.me.core.data.mapping

import org.me.core.data.dto.GetMovieDetailDTO
import org.me.core.data.dto.GetMovieDetailDTO.GenreDTO
import org.me.core.data.entity.GetMovieDetailEntity
import org.me.core.data.entity.GetMovieDetailEntity.GenreEntity
import javax.inject.Inject

interface MovieDetailDataMapping {

  fun GetMovieDetailEntity.toGetMovieDetailDTO(): GetMovieDetailDTO

  fun GetMovieDetailEntity.GenreEntity.toGenreDTO(): GenreDTO

  class Impl @Inject constructor() : MovieDetailDataMapping {

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
  }
}
