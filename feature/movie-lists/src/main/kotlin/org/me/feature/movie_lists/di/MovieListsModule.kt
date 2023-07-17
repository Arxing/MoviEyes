package org.me.feature.movie_lists.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import org.me.feature.movie_lists.mapping.MovieDetailMapping
import org.me.feature.movie_lists.mapping.MovieMapping

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class MovieListsModule {

  @Binds
  abstract fun bindMovieDetailMapping(impl: MovieDetailMapping.Impl): MovieDetailMapping

  @Binds
  abstract fun bindMovieMapping(impl: MovieMapping.Impl): MovieMapping
}
