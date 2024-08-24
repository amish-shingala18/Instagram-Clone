package com.example.instagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.R
import com.example.instagram.adapter.ChatRecyclerAdapter
import com.example.instagram.databinding.FragmentPrimaryBinding
import com.example.instagram.model.ChatsModel

class PrimaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPrimaryBinding.inflate(layoutInflater)
        val chatList = mutableListOf<ChatsModel>()

        chatList.add(ChatsModel("rvcj",R.drawable.rvcj,"Active 1h ago"))
        chatList.add(ChatsModel("androidstudio",R.drawable.android_studio,"Active 2h ago"))
        chatList.add(ChatsModel("flutter.deviser",R.drawable.flutter,"Active 3h ago"))
        chatList.add(ChatsModel("android",R.drawable.android,"Active 4h ago"))
        chatList.add(ChatsModel("kotlindevelopers",R.drawable.kotlin,"Active 5h ago"))
        chatList.add(ChatsModel("rvcj",R.drawable.rvcj,"Active 1h ago"))
        chatList.add(ChatsModel("androidstudio",R.drawable.android_studio,"Active 2h ago"))
        chatList.add(ChatsModel("flutter.deviser",R.drawable.flutter,"Active 3h ago"))
        chatList.add(ChatsModel("android",R.drawable.android,"Active 4h ago"))
        chatList.add(ChatsModel("kotlindevelopers",R.drawable.kotlin,"Active 5h ago"))

        val chatRecyclerAdapter = ChatRecyclerAdapter(chatList)
        binding.rvPrimary.adapter = chatRecyclerAdapter
        return binding.root
    }
}