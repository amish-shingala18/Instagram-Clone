package com.example.instagram.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.instagram.R
import com.example.instagram.model.StoryModel
import com.example.instagram.databinding.StoryBinding

class StoryAdapter(private var stories: MutableList<StoryModel>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if(position==0) {
            0
        } else{
            1
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view1 = LayoutInflater.from(parent.context).inflate(R.layout.your_story, parent, false)

        val view = LayoutInflater.from(parent.context).inflate(R.layout.story, parent, false)
        return if(viewType==0) {
            AddStoryViewHolder(view1)
        }else {
            StoryViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(holder is StoryViewHolder) {
            if (!stories[position].isExpanded) {
                holder.storyBinding.nameItem.text = stories[position].storyText!!.substring(0,7) + "..."
            }
            else {
                holder.storyBinding.nameItem.text = stories[position].storyText!!
            }
            holder.storyBinding.imgItem.setImageResource(stories[position].storyImage!!)
        }
        else {
            // add story
        }
    }
    class StoryViewHolder(itemView: View) : ViewHolder(itemView) {
        val storyBinding: StoryBinding = StoryBinding.bind(itemView)
    }

    class AddStoryViewHolder(itemView: View) : ViewHolder(itemView)
}