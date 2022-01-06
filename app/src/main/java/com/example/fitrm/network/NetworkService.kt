package com.example.fitrm.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object NetworkService {
    @ExperimentalSerializationApi
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://demo5350865.mockable.io/")
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .build()
    @ExperimentalSerializationApi
    private val restApi = retrofit.create(RestApi::class.java)
    @ExperimentalSerializationApi
    suspend fun loadProtein() = restApi.loadProtein()
    @ExperimentalSerializationApi
    suspend fun loadCreatine() = restApi.loadCreatine()
    @ExperimentalSerializationApi
    suspend fun loadGlutamine() = restApi.loadGlutamine()
    @ExperimentalSerializationApi
    suspend fun loadTraining() = restApi.loadTraining()
}