package com.example.fitrm.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Training(
    val morning: List<String>,
    val evening: List<String>
)
