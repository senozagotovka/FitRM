package com.example.fitrm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitrm.R
import com.example.fitrm.activity.MainActivity
import com.example.fitrm.adapter.ProductAdapter
import com.example.fitrm.data.DataSource.products2
import com.example.fitrm.databinding.FragmentProductsBinding

class CreatineFragment : Fragment(R.layout.fragment_products){
    private lateinit var binding: FragmentProductsBinding

    companion object {
        fun newInstance() = CreatineFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProducts.adapter =
            ProductAdapter(products2) { (name, description, image, price) ->
                (activity as MainActivity).navigateToFragment(
                    DetailsFragment.newInstance(name, description, image, price)
                )
            }
    }
}
