package org.me.feature.account.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddFavoriteDTO(
  val success: Boolean,
  val statusCode: Int,
  val statusMessage: String
) : Parcelable
