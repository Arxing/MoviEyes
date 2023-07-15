package org.me.feature.account.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import org.me.feature.account.mapping.FavoriteMapping
import org.me.feature.account.mapping.FavoriteMappingImpl
import org.me.feature.account.model.AccountApi
import org.me.feature.account.model.AccountRepository
import org.me.feature.account.model.AccountRepositoryImpl
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class AccountModule {

  @Binds
  abstract fun bindAccountRepository(impl: AccountRepositoryImpl): AccountRepository

  @Binds
  abstract fun bindAccountMapping(impl: FavoriteMappingImpl): FavoriteMapping

  companion object {

    @Provides
    fun provideAccountApi(retrofit: Retrofit): AccountApi {
      return retrofit.create(AccountApi::class.java)
    }
  }
}
