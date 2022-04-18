package com.artem.exchangeapp.data.remote


import com.artem.exchangeapp.data.remote.modelDTO.CurrencyRatesDTO
import com.artem.exchangeapp.presentation.utils.END_POINT_LATEST
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyAPI {

    @GET("/latest")
    suspend fun getRates(
        @Query("base") base: String,
        @Query("symbols") symbols: String
    ): Response<CurrencyRatesDTO>

}


