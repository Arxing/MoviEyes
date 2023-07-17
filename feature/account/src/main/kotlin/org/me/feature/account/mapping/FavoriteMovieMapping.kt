package org.me.feature.account.mapping

import org.me.core.data.dto.FavoriteMovieDTO
import org.me.feature.account.data.FavoriteMovieCardState
import javax.inject.Inject

interface FavoriteMovieMapping {

  fun FavoriteMovieDTO.toFavoriteMovieCardState(): FavoriteMovieCardState

  class Impl @Inject constructor() : FavoriteMovieMapping {

    override fun FavoriteMovieDTO.toFavoriteMovieCardState(): FavoriteMovieCardState {
      return FavoriteMovieCardState(movieId, coverUrl, title)
    }
  }
}
