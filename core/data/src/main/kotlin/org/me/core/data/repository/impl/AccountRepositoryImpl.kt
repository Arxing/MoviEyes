package org.me.core.data.repository.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.me.core.data.db.FavoriteMovieDao
import org.me.core.data.dto.FavoriteMovieDTO
import org.me.core.data.mapping.FavoriteMovieDataMapping
import org.me.core.data.repository.AccountRepository
import javax.inject.Inject

internal class AccountRepositoryImpl @Inject constructor(
  private val favoriteMovieDao: FavoriteMovieDao,
  private val favoriteMovieDataMapping: FavoriteMovieDataMapping,
) : AccountRepository, FavoriteMovieDataMapping by favoriteMovieDataMapping {

  override fun isFavorite(movieId: Int): Boolean {
    return favoriteMovieDao.exists(movieId)
  }

  override fun observeFavoriteMovies(): Flow<List<FavoriteMovieDTO>> {
    return favoriteMovieDao
      .getAll()
      .map { entities -> entities.map { it.toFavoriteMovieDTO() } }
  }

  override fun upsertFavorite(movie: FavoriteMovieDTO) {
    with(favoriteMovieDao) {
      if (exists(movie.movieId)) {
        update(movie.toFavoriteMovieEntity())
      } else {
        insert(movie.toFavoriteMovieEntity())
      }
    }
  }

  override fun deleteFavorite(movieId: Int) {
    with(favoriteMovieDao) {
      if (exists(movieId)) {
        delete(movieId)
      }
    }
  }
}
