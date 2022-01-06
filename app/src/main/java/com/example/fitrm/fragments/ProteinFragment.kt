package com.example.fitrm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitrm.R
import com.example.fitrm.activity.MainActivity
import com.example.fitrm.adapter.ProductAdapter
import com.example.fitrm.databinding.FragmentProductsBinding
import com.example.fitrm.network.NetworkService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi

class ProteinFragment : Fragment(R.layout.fragment_products) {
    private lateinit var binding: FragmentProductsBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ ->
        binding.progressBar.visibility = View.GONE
        binding.rvProducts.layoutManager = LinearLayoutManager(context)
        binding.rvProducts.adapter =
            ProductAdapter(listOf()) {}
        binding.swipeRefreshLayout.isRefreshing = false
        Snackbar.make(
            requireView(),
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).show()
    }
    private val scope =
        CoroutineScope(Dispatchers.Main + SupervisorJob() + coroutineExceptionHandler)

    companion object {
        fun newInstance() = ProteinFragment()
    }

    @ExperimentalSerializationApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        loadProtein()

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = true
            loadProtein()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    @ExperimentalSerializationApi
    private fun loadProtein() {
        scope.launch {
            val protein = NetworkService.loadProtein()
            binding.rvProducts.layoutManager = LinearLayoutManager(context)
            binding.rvProducts.adapter =
                ProductAdapter(protein) { (name, description, image, price) ->
                    (activity as MainActivity).navigateToFragment(
                        DetailsFragment.newInstance(name, description, image, price)
                    )
                }
            binding.progressBar.visibility = View.GONE
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}
