package com.example.instagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.R
import com.example.instagram.adapter.ProfileReelAdapter
import com.example.instagram.databinding.FragmentProfileReelBinding
import com.example.instagram.model.ProfileReelModel

class ProfileReelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profile_reel,container,false)
        val binding = FragmentProfileReelBinding.bind(view)
        val listProfileReel = mutableListOf<ProfileReelModel>()

        listProfileReel.add(ProfileReelModel(R.drawable.amish3))
        listProfileReel.add(ProfileReelModel(R.drawable.amish2))
        listProfileReel.add(ProfileReelModel(R.drawable.amish4))
        listProfileReel.add(ProfileReelModel(R.drawable.amish))
        listProfileReel.add(ProfileReelModel(R.drawable.amish3))
        listProfileReel.add(ProfileReelModel(R.drawable.amish2))
        listProfileReel.add(ProfileReelModel(R.drawable.amish4))
        listProfileReel.add(ProfileReelModel(R.drawable.amish))
        listProfileReel.add(ProfileReelModel(R.drawable.amish3))
        listProfileReel.add(ProfileReelModel(R.drawable.amish2))
        listProfileReel.add(ProfileReelModel(R.drawable.amish4))
        listProfileReel.add(ProfileReelModel(R.drawable.amish))

        val adapter = ProfileReelAdapter(listProfileReel)
        binding.rvProfileReels.adapter = adapter


        return binding.root
    }
}