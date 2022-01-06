package com.example.fitrm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitrm.R
import com.example.fitrm.activity.MainActivity
import com.example.fitrm.databinding.FragmentRegBinding

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