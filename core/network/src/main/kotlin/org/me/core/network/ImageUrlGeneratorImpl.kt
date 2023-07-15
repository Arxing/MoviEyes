package org.me.core.network

import javax.inject.Inject

internal class ImageUrlGeneratorImpl @Inject constructor() : ImageUrlGenerator {

  override fun generateImageUrl(path: String, size: Int): String {
    return "https://image.tmdb.org/t/p/w$size$path"
  }
}
