package org.me.core.model

import com.google.gson.annotations.SerializedName

data class AddFavoritePayloadEntity(
  @SerializedName("media_type") val mediaType: String,
  @SerializedName("media_id") val mediaId: Int,
  @SerializedName("favorite") val favorite: Boolean
)
