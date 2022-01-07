package com.example.fitrm.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitrm.R
import com.example.fitrm.databinding.FragmentNavigationBinding
import android.content.Intent
import com.example.fitrm.presentation.activity.MainActivity
import com.example.fitrm.presentation.activity.VideoActivity

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
        binding.training.setOnClickListener {
            (activity as MainActivity).navigateToFragment(TrainingFragment.newInstance())
        }
        binding.video.setOnClickListener {
            val intent = Intent(activity, VideoActivity::class.java)
            startActivity(intent)
        }
    }
}