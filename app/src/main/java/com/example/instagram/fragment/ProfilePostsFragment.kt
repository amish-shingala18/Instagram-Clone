package com.example.instagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.R
import com.example.instagram.adapter.ProfilePostAdapter
import com.example.instagram.databinding.FragmentProfilePostsBinding
import com.example.instagram.model.ProfilePostModel

class ProfilePostsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profile_posts, container, false)
        val binding = FragmentProfilePostsBinding.bind(view)
        val listProfilePost = mutableListOf<ProfilePostModel>()

        listProfilePost.add(ProfilePostModel(R.drawable.amish))
        listProfilePost.add(ProfilePostModel(R.drawable.amish))
        listProfilePost.add(ProfilePostModel(R.drawable.amish))
        listProfilePost.add(ProfilePostModel(R.drawable.amish))

        val adapter = ProfilePostAdapter(listProfilePost)
        binding.rvProfilePosts.adapter = adapter
        return binding.root
    }
}