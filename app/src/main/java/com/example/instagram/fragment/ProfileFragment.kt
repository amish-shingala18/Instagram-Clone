package com.example.instagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import com.example.instagram.R
import com.example.instagram.R.drawable.post_tag
import com.example.instagram.R.drawable.profile_posts
import com.example.instagram.R.drawable.video
import com.example.instagram.adapter.ProfileTabAdapter
import com.example.instagram.databinding.FragmentProfileBinding
import com.example.instagram.helper.SharedHelper
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val binding = FragmentProfileBinding.bind(view)
        val helper = SharedHelper()

        val theme = activity?.let { helper.getTheme(it) }
        binding.themeSwitcher.isChecked=theme!!

        binding.themeSwitcher.setOnCheckedChangeListener { _, isChecked ->
            addTheme(isChecked)
            helper.setTheme(requireActivity(),isChecked)
        }
        binding.imgMenu.setOnClickListener {
            binding.drawerMain.openDrawer(GravityCompat.END)
        }
        val profileTabAdapter = ProfileTabAdapter(this)
        binding.vpProfile.adapter = profileTabAdapter
        TabLayoutMediator(binding.postsTabLayout, binding.vpProfile){ tab, position ->
            when(position){
                0-> tab.setIcon(profile_posts)
                1-> tab.setIcon(video)
                2-> tab.setIcon(post_tag)
            }
        }.attach()
        return binding.root
    }
    private fun addTheme(theme: Boolean) {
        if (theme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}