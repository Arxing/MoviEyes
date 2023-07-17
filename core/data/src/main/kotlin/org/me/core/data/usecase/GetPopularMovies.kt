package org.me.core.data.usecase

import org.me.core.data.dto.GetPopularMoviesDTO
import org.me.core.data.repository.MovieListsRepository
import javax.inject.Inject

class GetPopularMovies @Inject internal constructor(
  private val repository: MovieListsRepository,
) {

  suspend operator fun invoke(
    language: String? = "zh-TW",
    page: Int? = null,
    sortBy: String? = null,
  ): GetPopularMoviesDTO {
    return repository.getPopularMovies(language, page, sortBy)
  }
}
