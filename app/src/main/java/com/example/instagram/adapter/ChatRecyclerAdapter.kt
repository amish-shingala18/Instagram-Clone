package com.example.instagram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.databinding.ChatsBinding
import com.example.instagram.model.ChatsModel

class ChatRecyclerAdapter(private var chatList: List<ChatsModel>) : RecyclerView.Adapter<ChatRecyclerAdapter.ChatViewHolder>() {
    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding = ChatsBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chats, parent, false)
        return ChatViewHolder(view)
    }
    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.binding.imgProfile.setImageResource(chatList[position].chatImage)
        holder.binding.chatUserName.text = chatList[position].chatName
        holder.binding.chatLastMessage.text=chatList[position].chatLastMessage
    }
}