package org.me.core.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetMovieDetailDTO(
  val adult: Boolean,
  val backdropPath: String,
  val budget: Int,
  val genres: List<GenreDTO>,
  val homepage: String,
  val id: Int,
  val imdbId: String,
  val originalLanguage: String,
  val originalTitle: String,
  val overview: String,
  val popularity: Double,
  val posterPath: String,
  val releaseDate: String,
  val revenue: Int,
  val runtime: Int,
  val status: String,
  val tagline: String,
  val title: String,
  val video: Boolean,
  val voteAverage: Double,
  val voteCount: Int
) : Parcelable {

  @Parcelize
  data class GenreDTO(
    val id: Int,
    val name: String
  ) : Parcelable
}
