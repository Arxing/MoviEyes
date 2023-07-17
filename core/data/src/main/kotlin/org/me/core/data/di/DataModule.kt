package org.me.core.data.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.me.core.data.db.FavoriteMovieDao
import org.me.core.data.db.MEDatabase
import org.me.core.data.mapping.FavoriteMovieMapping
import org.me.core.data.mapping.MovieDataMapping
import org.me.core.data.mapping.MovieDetailDataMapping
import org.me.core.data.mapping.PopularMoviesDataMapping
import org.me.core.data.repository.AccountRepository
import org.me.core.data.repository.MovieListsApi
import org.me.core.data.repository.MovieListsRepository
import org.me.core.data.repository.impl.AccountRepositoryImpl
import org.me.core.data.repository.impl.MovieListsRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

  @Binds
  abstract fun bindAccountRepository(impl: AccountRepositoryImpl): AccountRepository

  @Binds
  abstract fun bindPopularMoviesRepository(impl: MovieListsRepositoryImpl): MovieListsRepository

  @Binds
  abstract fun bindPopularMoviesMapping(impl: PopularMoviesDataMapping.Impl): PopularMoviesDataMapping

  @Binds
  abstract fun bindMovieMapping(impl: MovieDataMapping.Impl): MovieDataMapping

  @Binds
  abstract fun bindMovieDetailMapping(impl: MovieDetailDataMapping.Impl): MovieDetailDataMapping

  @Binds
  abstract fun bindFavoriteMovieMapping(impl: FavoriteMovieMapping.Impl): FavoriteMovieMapping

  companion object {

    @Provides
    fun providePopularMoviesApi(retrofit: Retrofit): MovieListsApi {
      return retrofit.create(MovieListsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMEDatabase(@ApplicationContext context: Context): MEDatabase {
      return Room.databaseBuilder(context, MEDatabase::class.java, "me").build()
    }

    @Provides
    fun provideFavoriteMovieDao(database: MEDatabase): FavoriteMovieDao {
      return database.favoriteMovieDao()
    }
  }
}
