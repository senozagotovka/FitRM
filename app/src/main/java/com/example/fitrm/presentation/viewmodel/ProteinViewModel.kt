package com.example.fitrm.presentation.viewmodel

import android.content.Context
import com.example.fitrm.R
import com.example.fitrm.domain.network.NetworkService
import com.example.fitrm.presentation.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi

class ProteinViewModel(
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState> = _screenState

    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                _screenState.emit(ScreenState.Loading)
                val protein = NetworkService.loadProtein()
                _screenState.emit(ScreenState.DataLoaded(protein))
            } catch (ex: Throwable) {
                _screenState.emit(ScreenState.Error(context.resources.getString(R.string.error)))
            }
        }
    }
}