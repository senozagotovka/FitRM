package com.example.fitrm.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitrm.R
import com.example.fitrm.databinding.FragmentRegBinding
import com.example.fitrm.presentation.activity.MainActivity

class RegFragment : Fragment(R.layout.fragment_reg) {
    private lateinit var binding: FragmentRegBinding

    companion object {
        fun newInstance() = RegFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.buttonSignUp.setOnClickListener {
            (activity as MainActivity).navigateToFragment(LoginFragment.newInstance())
        }
    }
}