package com.johannainggolan.kotlinme.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [PostTabling::class], version = 1, exportSchema = false)
abstract class PostTablingDatabase : RoomDatabase() {

    abstract fun savedObjectDao(): PostTablingDao

    companion object {

        @Volatile
        private var INSTANCE: PostTablingDatabase? = null

        fun getDatabase(context: Context):PostTablingDatabase? {
            if (INSTANCE == null) {
                synchronized(PostTablingDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            PostTablingDatabase::class.java, "message_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}