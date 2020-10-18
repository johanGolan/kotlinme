package com.johannainggolan.kotlinme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.johannainggolan.kotlinme.Adapters.MainAdapter
import com.johannainggolan.kotlinme.Model.PostItemModel
import com.johannainggolan.kotlinme.Utils.ConsumeStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


//Room Database
//https://github.com/rolandwu23/room_chat_medium/tree/master/app/src/main/java/com/eonreality/roomchat

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val exampleViewModel: KotlinViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupComponents()
        consumeObserver()

    }

    private fun setupComponents() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    fun consumeObserver() {

        exampleViewModel.posts.observe(this, Observer {
            when (it.status) {
                ConsumeStatus.OK -> {
                    it.data?.let { users -> implementAdapter(users) }
                    recyclerView.visibility = View.VISIBLE
                }
            }

        })
    }

    private fun implementAdapter(posts: List<PostItemModel>) {
        adapter.addData(posts)
        adapter.notifyDataSetChanged()
    }


}