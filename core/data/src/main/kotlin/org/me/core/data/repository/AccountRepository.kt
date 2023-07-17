package org.me.core.data.repository

import kotlinx.coroutines.flow.Flow
import org.me.core.data.dto.FavoriteMovieDTO

interface AccountRepository {

  fun isFavorite(movieId: Int): Boolean

  fun observeFavoriteMovies(): Flow<List<FavoriteMovieDTO>>

  fun upsertFavorite(movie: FavoriteMovieDTO)

  fun deleteFavorite(movieId: Int)
}
