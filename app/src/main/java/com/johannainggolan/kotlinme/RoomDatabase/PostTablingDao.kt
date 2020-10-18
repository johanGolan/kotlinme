package com.johannainggolan.kotlinme.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.johannainggolan.kotlinme.Model.PostItemModel

@Dao
interface PostTablingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMessage(movie: PostTabling)

    @Query("SELECT * from PostTable ORDER BY id ASC")
    fun getMessages() : LiveData<List<PostItemModel>>

    @Query("DELETE FROM PostTable")
    fun deleteAll()

}