package org.me.feature.movie_lists.mapping

import org.me.core.model.GetPopularMoviesEntity
import org.me.core.model.GetPopularMoviesEntity.ResultEntity
import org.me.feature.movie_lists.data.GetPopularMoviesDTO
import org.me.feature.movie_lists.data.GetPopularMoviesDTO.ResultDTO
import javax.inject.Inject

internal class PopularMoviesMappingImpl @Inject constructor() : PopularMoviesMapping {

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
