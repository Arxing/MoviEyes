package org.me.feature.movie_lists.data

class MovieDetailScreenState(
  val coverUrl: String = "",
  val backdropUrl: String = "",
  val title: String = "",
  val overview: String = "",
  val releaseDate: String = "",
  val genres: List<String> = emptyList(),
  val voteAverage: Float = 0f,
)
