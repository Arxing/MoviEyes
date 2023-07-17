package org.me.core.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.me.core.data.entity.FavoriteMovieEntity

@Dao
interface FavoriteMovieDao {

  @Query("SELECT * FROM favorite_movie ORDER BY modified")
  fun getAll(): Flow<List<FavoriteMovieEntity>>

  @Query("SELECT EXISTS(SELECT * FROM favorite_movie WHERE movieId=:movieId)")
  fun exists(movieId: Int): Boolean

  @Query("SELECT * FROM favorite_movie WHERE movieId=:movieId")
  fun findById(movieId: Int): FavoriteMovieEntity

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(movie: FavoriteMovieEntity)

  @Query("DELETE FROM favorite_movie WHERE movieId=:movieId")
  fun delete(movieId: Int)

  @Update
  fun update(movie: FavoriteMovieEntity)
}
