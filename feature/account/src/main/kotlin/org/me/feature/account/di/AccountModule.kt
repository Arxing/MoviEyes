package org.me.feature.account.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import org.me.feature.account.mapping.FavoriteMovieMapping

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AccountModule {

  @Binds
  abstract fun bindFavoriteMovieMapping(impl: FavoriteMovieMapping.Impl): FavoriteMovieMapping
}
