package org.me.core.data.usecase

import kotlinx.coroutines.flow.Flow
import org.me.core.data.dto.FavoriteMovieDTO
import org.me.core.data.repository.AccountRepository
import javax.inject.Inject

class ObserveFavorites @Inject constructor(
  private val repository: AccountRepository,
) {

  operator fun invoke(): Flow<List<FavoriteMovieDTO>> {
    return repository.observeFavoriteMovies()
  }
}
