package com.johannainggolan.kotlinme

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johannainggolan.kotlinme.Model.PostItemModel
import com.johannainggolan.kotlinme.Repository.PostRepository
import com.johannainggolan.kotlinme.Utils.WrapperResponse
import kotlinx.coroutines.launch


class KotlinViewModel @ViewModelInject constructor(private val postRepo: PostRepository) :
    ViewModel() {

    private val _posts = MutableLiveData<WrapperResponse<List<PostItemModel>>>()
    val posts: LiveData<WrapperResponse<List<PostItemModel>>>
        get() = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            //making state of on progress consume rest api from jsonplaceholder
            //_posts.postValue(WrapperResponse.loading(null))
            postRepo.getPosts().let {
                if (it.isSuccessful) {
                    _posts.postValue(WrapperResponse.success(it.body()))
                } else {
                    _posts.postValue(WrapperResponse.error("no data is avaliable", it.body()))
                }
            }

        }
    }// end of fetch post

}//end of curly brackets

