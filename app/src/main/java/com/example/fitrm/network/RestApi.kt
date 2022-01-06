package com.example.fitrm.network

import com.example.fitrm.model.Product
import com.example.fitrm.model.Training
import retrofit2.http.GET

interface RestApi {
    @GET("protein")
    suspend fun loadProtein(): List<Product>
    @GET("creatine")
    suspend fun loadCreatine(): List<Product>
    @GET("glutamine")
    suspend fun loadGlutamine(): List<Product>
    @GET("training")
    suspend fun loadTraining(): List<Training>
}