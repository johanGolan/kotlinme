package com.johannainggolan.kotlinme.ApiCall


import com.johannainggolan.kotlinme.Model.PostItemModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getPosts(): Response<List<PostItemModel>>  =  apiService.getPosts();
}