package com.example.fitrm.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitrm.R
import com.example.fitrm.databinding.FragmentTrainingBinding
import com.example.fitrm.model.Training
import com.example.fitrm.network.NetworkService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi

class TrainingFragment : Fragment(R.layout.fragment_training) {
    private lateinit var binding: FragmentTrainingBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ ->
        Snackbar.make(
            requireView(),
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).show()
    }
    private val scope =
        CoroutineScope(Dispatchers.Main + SupervisorJob() + coroutineExceptionHandler)

    companion object {
        fun newInstance() = TrainingFragment()
    }

    @ExperimentalSerializationApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTrainingBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        loadTraining()
    }

    @ExperimentalSerializationApi
    private fun loadTraining() {
        scope.launch {
            val training = NetworkService.loadTraining()
            val builder = StringBuilder()
            for (i in training.indices) {
                builder.append(" ")
                builder.append("${i + 1}" + ". Утром: " + training[i].morning + ", Вечером: " + training[i].evening)
                builder.append("\n\n")
            }
            binding.textTraining.text = builder.toString()
        }

    }
}