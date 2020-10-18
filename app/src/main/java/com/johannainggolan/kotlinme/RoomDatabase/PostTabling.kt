package com.johannainggolan.kotlinme.RoomDatabase


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostTable")
data class PostTabling(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "body")
    var body:String

)