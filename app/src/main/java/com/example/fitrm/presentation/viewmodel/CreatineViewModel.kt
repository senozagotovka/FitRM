package com.example.fitrm.presentation.viewmodel

import android.content.Context
import com.example.fitrm.R
import com.example.fitrm.data.database.DatabaseProvider
import com.example.fitrm.domain.network.NetworkService
import com.example.fitrm.presentation.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import java.io.IOException

class CreatineViewModel(
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState> = _screenState
    private val creatineDao = DatabaseProvider.provideDatabase(context).productsDao()

    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                _screenState.value = ScreenState.Loading
                val creatine = try {
                    NetworkService(context).loadCreatine().also {
                        creatineDao.insertAll(it)
                    }
                } catch (ex: IOException){
                    creatineDao.getAll()
                }
                _screenState.value = ScreenState.DataLoaded(creatine)
            } catch(ex: Throwable) {
                _screenState.value = ScreenState.Error(context.getString(R.string.error))
            }
        }
    }
}