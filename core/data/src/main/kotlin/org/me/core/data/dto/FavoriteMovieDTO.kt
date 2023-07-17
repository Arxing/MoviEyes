package org.me.core.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavoriteMovieDTO(
  val movieId: Int,
  val coverUrl: String,
  val title: String,
  val releaseDate: String,
  val overview: String,
) : Parcelable
