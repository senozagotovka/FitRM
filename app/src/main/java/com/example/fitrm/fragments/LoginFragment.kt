package com.example.fitrm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitrm.R
import com.example.fitrm.activity.MainActivity
import com.example.fitrm.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.buttonReg.setOnClickListener {
            (activity as MainActivity).navigateToFragment(RegFragment.newInstance())
        }
        binding.buttonSignIn.setOnClickListener {
            (activity as MainActivity).navigateToFragment(NavigationFragment.newInstance())
        }
    }
}