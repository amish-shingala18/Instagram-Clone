package com.example.instagram.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagram.fragment.ProfileReelFragment
import com.example.instagram.fragment.ProfilePostsFragment

class ProfileTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> ProfilePostsFragment()
            1-> ProfileReelFragment()
            else -> ProfilePostsFragment()
        }
    }
}