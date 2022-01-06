package com.example.fitrm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitrm.R
import com.example.fitrm.activity.MainActivity
import com.example.fitrm.activity.VideoActivity
import com.example.fitrm.databinding.FragmentNavigationBinding
import android.content.Intent

class NavigationFragment : Fragment(R.layout.fragment_navigation) {
    private lateinit var binding: FragmentNavigationBinding

    companion object {
        fun newInstance() = NavigationFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNavigationBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.sportpit.setOnClickListener {
            (activity as MainActivity).navigateToFragment(CategoriesFragment.newInstance())
        }
        binding.video.setOnClickListener {
            val intent = Intent(activity, VideoActivity::class.java)
            startActivity(intent)
        }
    }
}