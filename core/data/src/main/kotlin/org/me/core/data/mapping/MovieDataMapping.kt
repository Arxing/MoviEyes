package org.me.core.data.mapping

import org.me.core.data.dto.GetPopularMoviesDTO
import org.me.core.data.dto.GetPopularMoviesDTO.ResultDTO
import org.me.core.data.dto.MovieDTO
import javax.inject.Inject

interface MovieDataMapping {

  fun GetPopularMoviesDTO.ResultDTO.toMovieDTO(): MovieDTO

  class Impl @Inject constructor() : MovieDataMapping {

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
  }
}
