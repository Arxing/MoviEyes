package org.me.core.data.usecase

import org.me.core.data.dto.GetMovieDetailDTO
import org.me.core.data.repository.MovieListsRepository
import javax.inject.Inject

class GetMovieDetail @Inject internal constructor(
  private val repository: MovieListsRepository,
) {

  suspend operator fun invoke(movieId: Int, language: String? = "zh-TW"): GetMovieDetailDTO {
    return repository.getMovieDetail(movieId, language)
  }
}
