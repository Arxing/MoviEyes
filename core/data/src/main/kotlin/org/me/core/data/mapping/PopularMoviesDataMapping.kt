package org.me.core.data.mapping

import org.me.core.data.dto.GetPopularMoviesDTO
import org.me.core.data.dto.GetPopularMoviesDTO.ResultDTO
import org.me.core.data.entity.GetPopularMoviesEntity
import org.me.core.data.entity.GetPopularMoviesEntity.ResultEntity
import javax.inject.Inject

interface PopularMoviesDataMapping {

  fun GetPopularMoviesEntity.toGetPopularMoviesDTO(): GetPopularMoviesDTO

  fun GetPopularMoviesEntity.ResultEntity.toResultDTO(): GetPopularMoviesDTO.ResultDTO

  class Impl @Inject constructor() : PopularMoviesDataMapping {

    override fun GetPopularMoviesEntity.toGetPopularMoviesDTO(): GetPopularMoviesDTO {
      return GetPopularMoviesDTO(
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
}
