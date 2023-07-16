package org.me.feature.movie_lists.usecase

import org.me.feature.movie_lists.data.GetMovieDetailDTO
import org.me.feature.movie_lists.model.MovieListsRepository
import javax.inject.Inject

class GetMovieDetail @Inject internal constructor(
  private val repository: MovieListsRepository,
) {

  suspend operator fun invoke(movieId: Int, language: String? = "zh-TW"): GetMovieDetailDTO {
    return repository.getMovieDetail(movieId, language)
  }
}
