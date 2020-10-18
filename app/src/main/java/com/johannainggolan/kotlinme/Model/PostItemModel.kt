package com.johannainggolan.kotlinme.Model

import com.squareup.moshi.Json

data class PostItemModel(
    @field:Json(name = "body")
    val body: String = "",
    @field:Json(name = "id")
    val id: Int = 0,
    @field:Json(name = "title")
    val title: String = "",
    @field:Json(name = "userId")
    val userId: Int = 0
)