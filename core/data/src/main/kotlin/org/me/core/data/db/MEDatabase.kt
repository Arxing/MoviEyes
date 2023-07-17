package org.me.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.me.core.data.entity.FavoriteMovieEntity

@Database(entities = [FavoriteMovieEntity::class], version = 1)
abstract class MEDatabase : RoomDatabase() {

  abstract fun favoriteMovieDao(): FavoriteMovieDao
}
