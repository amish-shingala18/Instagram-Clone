package com.example.instagram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.databinding.ProfileReelBinding
import com.example.instagram.model.ProfileReelModel

class ProfileReelAdapter(private var profileReelList:List<ProfileReelModel>) : RecyclerView.Adapter<ProfileReelAdapter.ProfileReelViewHolder>() {
    class ProfileReelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profileReelBinding:ProfileReelBinding= ProfileReelBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileReelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_reel,parent,false)
        return ProfileReelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return profileReelList.size
    }

    override fun onBindViewHolder(holder: ProfileReelViewHolder, position: Int) {
        holder.profileReelBinding.reel1.setImageResource(profileReelList[position].video)
    }
}