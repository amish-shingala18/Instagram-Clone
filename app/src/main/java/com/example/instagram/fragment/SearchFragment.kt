package com.example.instagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.R
import com.example.instagram.adapter.SearchAdapter
import com.example.instagram.databinding.FragmentSearchBinding
import com.example.instagram.model.SearchModel

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val binding:FragmentSearchBinding=FragmentSearchBinding.bind(view)
        val searchList = mutableListOf<SearchModel>()
        searchList.add(SearchModel(R.drawable.amish, R.drawable.amish4, R.drawable.amish4,
            R.drawable.amish, R.drawable.amish3, R.drawable.amish3, R.drawable.amish,
            R.drawable.amish4, R.drawable.amish, R.drawable.amish4))
        searchList.add(SearchModel(R.drawable.amish, R.drawable.amish4, R.drawable.amish4,
            R.drawable.amish, R.drawable.amish3, R.drawable.amish3, R.drawable.amish,
            R.drawable.amish4, R.drawable.amish, R.drawable.amish4))
        searchList.add(SearchModel(R.drawable.amish, R.drawable.amish4, R.drawable.amish4,
            R.drawable.amish, R.drawable.amish3, R.drawable.amish3, R.drawable.amish,
            R.drawable.amish4, R.drawable.amish, R.drawable.amish4))
        val searchAdapter= SearchAdapter(searchList)
        binding.rvSearch.adapter=searchAdapter
        return binding.root
    }
}