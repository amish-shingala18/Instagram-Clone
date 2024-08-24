package com.example.instagram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.databinding.SearchBinding
import com.example.instagram.model.SearchModel

class SearchAdapter(private var searchList: MutableList<SearchModel>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search,parent,false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.searchBinding.imgSearch1.setImageResource(searchList[position].searchImg1)
        holder.searchBinding.imgSearch2.setImageResource(searchList[position].searchImg2)
        holder.searchBinding.imgSearch3.setImageResource(searchList[position].searchImg3)
        holder.searchBinding.imgSearch4.setImageResource(searchList[position].searchImg4)
        holder.searchBinding.imgSearch5.setImageResource(searchList[position].searchImg5)
        holder.searchBinding.imgSearch6.setImageResource(searchList[position].searchImg6)
        holder.searchBinding.imgSearch7.setImageResource(searchList[position].searchImg7)
        holder.searchBinding.imgSearch8.setImageResource(searchList[position].searchImg8)
        holder.searchBinding.imgSearch9.setImageResource(searchList[position].searchImg9)
        holder.searchBinding.imgSearch10.setImageResource(searchList[position].searchImg10)
    }

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val searchBinding:SearchBinding=SearchBinding.bind(itemView)
    }
}
