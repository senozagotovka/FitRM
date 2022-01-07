package com.example.fitrm.presentation

import com.example.fitrm.data.model.Product

sealed class ScreenState {
    data class DataLoaded(val products: List<Product>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}
