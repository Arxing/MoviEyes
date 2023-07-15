package org.me.feature.movie_lists.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import org.me.feature.movie_lists.mapping.PopularMoviesMapping
import org.me.feature.movie_lists.mapping.PopularMoviesMappingImpl
import org.me.feature.movie_lists.model.MovieListsApi
import org.me.feature.movie_lists.model.MovieListsRepository
import org.me.feature.movie_lists.model.MovieListsRepositoryImpl
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class MovieListsModule {

  @Binds
  abstract fun bindPopularMoviesRepository(impl: MovieListsRepositoryImpl): MovieListsRepository

  @Binds
  abstract fun bindPopularMoviesMapping(impl: PopularMoviesMappingImpl) : PopularMoviesMapping

  companion object {

    @Provides
    fun providePopularMoviesApi(retrofit: Retrofit): MovieListsApi {
      return retrofit.create(MovieListsApi::class.java)
    }
  }
}
