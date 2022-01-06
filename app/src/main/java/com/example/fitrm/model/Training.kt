package com.example.fitrm.model

import kotlinx.serialization.Serializable

@Serializable
data class Training(
    val morning: List<String>,
    val evening: List<String>
)
