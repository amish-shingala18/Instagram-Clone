package com.example.instagram.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.model.PostModel
import com.example.instagram.R
import com.example.instagram.databinding.PostBinding

class PostAdapter(private var posts: MutableList<PostModel>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.postBinding.imgPostUsers.setImageResource(posts[position].profileUser!!)
        holder.postBinding.imgPosted.setImageResource(posts[position].userImage!!)
        holder.postBinding.txtUserName.text = posts[position].userName
        holder.postBinding.txtLikeCount.text = "${posts[position].likeCount} likes"
        holder.postBinding.txtComments.text = posts[position].comments

        Log.e("TAG", "onBindViewHolder: ${posts[position].comments!!.length}")

        if (!posts[position].isExpanded) {
            holder.postBinding.txtComments.text = posts[position].comments!!.substring(0, 85) + "...more"
        } else {
            holder.postBinding.txtComments.text = posts[position].comments!!
        }
        holder.postBinding.txtComments.setOnClickListener {
            posts[position].isExpanded = !posts[position].isExpanded

            holder.postBinding.txtComments.text = posts[position].comments!!
            notifyDataSetChanged()
        }
    }
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postBinding: PostBinding = PostBinding.bind(itemView)
    }
}