package org.me.feature.movie_lists.mapping

import org.me.core.model.GetMovieDetailEntity
import org.me.feature.movie_lists.data.GetMovieDetailDTO
import org.me.feature.movie_lists.data.GetMovieDetailDTO.GenreDTO
import org.me.feature.movie_lists.data.MovieDetailScreenState

interface MovieDetailMapping {

  fun GetMovieDetailEntity.toGetMovieDetailDTO(): GetMovieDetailDTO

  fun GetMovieDetailEntity.GenreEntity.toGenreDTO(): GenreDTO

  fun GetMovieDetailDTO.toMovieDetailScreenState(): MovieDetailScreenState
}
