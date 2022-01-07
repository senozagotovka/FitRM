package com.example.fitrm.domain.network

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

class NetworkService(context: Context) {
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
}

object NetworkServiceTraining {
    @ExperimentalSerializationApi
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://demo5350865.mockable.io/")
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .build()

    @ExperimentalSerializationApi
    private val restApi = retrofit.create(RestApi::class.java)

    @ExperimentalSerializationApi
    suspend fun loadTraining() = restApi.loadTraining()
}