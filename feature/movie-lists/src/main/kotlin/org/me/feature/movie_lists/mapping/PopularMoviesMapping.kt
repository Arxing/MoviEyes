package org.me.feature.movie_lists.mapping

import org.me.core.model.GetPopularMoviesEntity
import org.me.feature.movie_lists.data.GetPopularMoviesDTO

internal interface PopularMoviesMapping {

  fun GetPopularMoviesEntity.toGetPopularMoviesDTO(): GetPopularMoviesDTO

  fun GetPopularMoviesEntity.ResultEntity.toResultDTO(): GetPopularMoviesDTO.ResultDTO
}
