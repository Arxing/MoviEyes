package org.me.core.data.usecase

import org.me.core.data.dto.FavoriteMovieDTO
import org.me.core.data.repository.AccountRepository
import javax.inject.Inject

class ChangeFavorite @Inject constructor(
  private val repository: AccountRepository,
) {

  operator fun invoke(movie: FavoriteMovieDTO, add: Boolean) {
    if (add) {
      repository.upsertFavorite(movie)
    } else {
      repository.deleteFavorite(movie.movieId)
    }
  }
}
