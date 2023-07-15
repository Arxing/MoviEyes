package org.me.core.network

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import org.me.core.network.NetworkAuth
import javax.inject.Inject

internal class AuthInterceptor @Inject constructor(
  private val auth: NetworkAuth,
) : Interceptor {

  override fun intercept(chain: Chain): Response {
    val request = chain.request().newBuilder()
      .header("Authorization", "Bearer ${auth.accessToken}")
      .header("accept", "application/json")
      .build()
    return chain.proceed(request)
  }
}
