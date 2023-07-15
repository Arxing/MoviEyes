package org.me.feature.account.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetFavoriteMoviesDTO(
  val page: Int,
  val results: List<ResultDTO>,
  val totalPages: Int,
  val totalResults: Int
) : Parcelable {

  @Parcelize
  data class ResultDTO(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
  ) : Parcelable
}
