package com.artem.exchangeapp.domain

import com.artem.exchangeapp.data.remote.modelDTO.CurrencyRatesDTO
import com.artem.exchangeapp.presentation.utils.Resource

interface MainRepository {

    suspend fun getRates(base:String,symbols:String): Resource<CurrencyRatesDTO>

//DataBase
    /*suspend fun upsert(rate: Rate)

    fun getFavoriteRates()

    suspend fun deleteArticle(rate: Rate)*/

}