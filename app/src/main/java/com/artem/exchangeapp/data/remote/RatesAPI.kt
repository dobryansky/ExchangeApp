package com.artem.exchangeapp.data.remote


import com.artem.exchangeapp.presentation.utils.END_POINT_LATEST
import retrofit2.http.GET

interface RatesAPI {
    @GET(END_POINT_LATEST)
    suspend fun getRates(): RatesDTO
}


