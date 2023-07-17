package org.me.core.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movie")
data class FavoriteMovieEntity(
  @PrimaryKey val movieId: Int,
  @ColumnInfo val coverUrl: String?,
  @ColumnInfo val title: String,
  @ColumnInfo val modified: Long,
)
