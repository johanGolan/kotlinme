package com.johannainggolan.kotlinme.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.johannainggolan.kotlinme.Model.PostItemModel
import com.johannainggolan.kotlinme.R
import kotlinx.android.synthetic.main.item_rv.view.*

class MainAdapter(
    private val posts: ArrayList<PostItemModel>
) : RecyclerView.Adapter<MainAdapter.RvViewHolder>() {

    class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: PostItemModel) {
            itemView.tvTitle.text = post.title
            itemView.tvSubtitle.text = post.body
            itemView.iv_post.load("") {
                placeholder(R.drawable.ic_launcher_background)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RvViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_rv, parent,
                false
            )
        )

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) =
        holder.bind(posts[position])

    fun addData(list: List<PostItemModel>) {
        posts.addAll(list)
    }

}