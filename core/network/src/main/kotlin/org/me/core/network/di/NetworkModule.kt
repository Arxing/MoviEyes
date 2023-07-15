package org.me.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.me.core.AuthInterceptor
import org.me.core.network.BuildConfig
import org.me.core.network.NetworkAuth
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {

  companion object {

    @Provides
    fun provideApiAuth(): NetworkAuth {
      return NetworkAuth(
        apiKey = BuildConfig.TMDB_API_KEY,
        accessToken = BuildConfig.TMDB_ACCESS_TOKEN,
      )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
      authInterceptor: AuthInterceptor,
    ): OkHttpClient {
      return OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
      okHttpClient: OkHttpClient,
    ) : Retrofit {
      return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.themoviedb.org/3/authentication")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
  }
}
