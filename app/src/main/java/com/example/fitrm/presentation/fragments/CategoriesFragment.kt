package com.example.fitrm.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitrm.R
import com.example.fitrm.databinding.FragmentCategoriesBinding
import com.example.fitrm.presentation.activity.MainActivity

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    private lateinit var binding: FragmentCategoriesBinding

    companion object {
        fun newInstance() = CategoriesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoriesBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.protein.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProteinFragment.newInstance())
        }
        binding.creatine.setOnClickListener {
            (activity as MainActivity).navigateToFragment(CreatineFragment.newInstance())
        }
        binding.glutamine.setOnClickListener {
            (activity as MainActivity).navigateToFragment(GlutamineFragment.newInstance())
        }
    }
}