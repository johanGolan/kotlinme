package com.johannainggolan.kotlinme.ApiCall

import com.johannainggolan.kotlinme.Model.PostItemModel
import retrofit2.Response

interface ApiHelper {

    suspend fun getPosts(): Response<List<PostItemModel>>
}