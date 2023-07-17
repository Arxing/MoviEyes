package org.me.core.data.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.me.core.data.repository.AccountRepository
import javax.inject.Inject

class ObserveIsInFavorites @Inject constructor(
  private val repository: AccountRepository,
) {

  operator fun invoke(movieId: Int): Flow<Boolean> {
    return flow {
      repository.observeFavoriteMovies().collect { favorites ->
        val isInFavorite = movieId in favorites.map { it.movieId }
        emit(isInFavorite)
      }
    }
  }
}
