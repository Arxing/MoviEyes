package org.me.core.network

interface ImageUrlGenerator {

  fun generateImageUrl(path: String, size: Int = 500): String
}
