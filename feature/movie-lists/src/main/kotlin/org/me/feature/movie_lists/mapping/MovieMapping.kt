package org.me.feature.movie_lists.mapping

import org.me.feature.movie_lists.data.GetPopularMoviesDTO
import org.me.feature.movie_lists.data.MovieCardState
import org.me.feature.movie_lists.data.MovieDTO

interface MovieMapping {

  fun GetPopularMoviesDTO.ResultDTO.toMovieDTO(): MovieDTO

  fun MovieDTO.toMovieCardState(): MovieCardState
}
