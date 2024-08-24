package com.example.instagram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.databinding.ProfilePostBinding
import com.example.instagram.model.ProfilePostModel

class ProfilePostAdapter(private var profilePostList:List<ProfilePostModel>) : RecyclerView.Adapter<ProfilePostAdapter.ProfilePostViewHolder>() {
    class ProfilePostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profilePostBinding:ProfilePostBinding= ProfilePostBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_post,parent,false)
        return ProfilePostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return profilePostList.size
    }

    override fun onBindViewHolder(holder: ProfilePostViewHolder, position: Int) {
        holder.profilePostBinding.post1.setImageResource(profilePostList[position].postProfile1)
    }

}