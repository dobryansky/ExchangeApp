package com.artem.exchangeapp.data.remote

import com.artem.exchangeapp.presentation.utils.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create


object RetrofitInstance {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val apiService:RatesAPI= retrofitBuilder.create()
}
