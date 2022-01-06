package com.example.fitrm.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val name: String,
    val description: String,
    val image: String,
    val price: Int
)
