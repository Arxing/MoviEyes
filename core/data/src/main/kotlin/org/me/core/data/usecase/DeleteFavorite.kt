package org.me.core.data.usecase

import org.me.core.data.repository.AccountRepository
import javax.inject.Inject

class DeleteFavorite @Inject constructor(
  private val repository: AccountRepository,
) {

  operator fun invoke(movieId: Int) {
    repository.deleteFavorite(movieId)
  }
}
