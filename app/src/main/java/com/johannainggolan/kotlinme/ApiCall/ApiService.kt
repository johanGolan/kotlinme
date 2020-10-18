package com.johannainggolan.kotlinme.ApiCall

import com.johannainggolan.kotlinme.Model.PostItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<PostItemModel>>

}