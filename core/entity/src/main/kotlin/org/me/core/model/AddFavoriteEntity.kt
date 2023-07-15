package org.me.core.model


import com.google.gson.annotations.SerializedName

data class AddFavoriteEntity(
  @SerializedName("success") val success: Boolean,
  @SerializedName("status_code") val statusCode: Int,
  @SerializedName("status_message") val statusMessage: String
)
