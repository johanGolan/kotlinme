package com.johannainggolan.kotlinme.Repository

import com.johannainggolan.kotlinme.ApiCall.ApiHelper
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getPosts() =  apiHelper.getPosts()
}