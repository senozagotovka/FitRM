package com.example.fitrm.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import coil.load
import com.example.fitrm.R
import com.example.fitrm.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private lateinit var binding: FragmentDetailsBinding

    companion object {
        private const val KEY_NAME = "KEY_NAME"
        private const val KEY_DESCRIPTION = "KEY_DESCRIPTION"
        private const val KEY_IMAGE = "KEY_IMAGE"
        private const val KEY_PRICE = "KEY_PRICE"

        fun newInstance(
            name: String,
            description: String,
            image: String,
            price: Int,
        ): DetailsFragment {
            val args = bundleOf(
                KEY_NAME to name,
                KEY_DESCRIPTION to description,
                KEY_IMAGE to image,
                KEY_PRICE to price
            )
            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        val name = arguments?.getString("KEY_NAME")
        val description = arguments?.getString("KEY_DESCRIPTION")
        val image = arguments?.getString("KEY_IMAGE")
        val price = arguments?.getInt("KEY_PRICE")

        if (image != null) {
            binding.ivItem.load(image)
        }
        binding.tvTitle.text = name
        binding.tvDescription.text = description
        binding.buttonBuy.text = price.toString()

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}