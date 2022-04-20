package com.artem.exchangeapp.data.mapper


import com.artem.exchangeapp.data.remote.modelDTO.CurrencyRatesDTO
import com.artem.exchangeapp.presentation.Rate

class RateMapper {

    fun mapRateDTOtoRate(rateDTO: CurrencyRatesDTO): List<Rate> {
        return listOf(
            Rate(1, "RUB", value = rateDTO.rates.rUB, favourite = false),
            Rate(2, "EUR", value = rateDTO.rates.eUR, favourite = false),
            Rate(3, "USD", value = rateDTO.rates.uSD, favourite = false),
            Rate(4, "BYN", value = rateDTO.rates.bYN, favourite = false),
            Rate(5, "PLN", value = rateDTO.rates.pLN, favourite = false),
            Rate(6, "GBP", value = rateDTO.rates.gBP, favourite = false),
            Rate(7, "KZT", value = rateDTO.rates.kZT, favourite = false),
            Rate(8, "ILS", value = rateDTO.rates.iLS, favourite = false),
            Rate(9, "CZK", value = rateDTO.rates.cZK, favourite = false),
            Rate(10, "AUD", value = rateDTO.rates.aUD, favourite = false),
            Rate(11, "HKD", value = rateDTO.rates.hKD, favourite = false),
            Rate(12, "IDR", value = rateDTO.rates.iDR, favourite = false),
            Rate(13, "CNY", value = rateDTO.rates.cNY, favourite = false),
            Rate(14, "JPY", value = rateDTO.rates.jPY, favourite = false),

            )
    }

    /*fun mapRateRateFavorite(rates:  List<Rate>):List<RateFavorite>{
        return listOf(
            Rate("RUB", value = rateDTO.rates.rUB, favourite = false),
            Rate("EUR", value = rateDTO.rates.eUR, favourite = false),
            Rate("USD", value = rateDTO.rates.uSD, favourite = false),
            Rate("BYN", value = rateDTO.rates.bYN, favourite = false),
            Rate("PLN", value = rateDTO.rates.pLN, favourite = false),
            Rate("GBP", value = rateDTO.rates.gBP, favourite = false),
            Rate("KZT", value = rateDTO.rates.kZT, favourite = false),
            Rate("ILS", value = rateDTO.rates.iLS, favourite = false),
            Rate("CZK", value = rateDTO.rates.cZK, favourite = false),
            Rate("AUD", value = rateDTO.rates.aUD, favourite = false),
            Rate("HKD", value = rateDTO.rates.hKD, favourite = false),
            Rate("IDR", value = rateDTO.rates.iDR, favourite = false),
            Rate("CNY", value = rateDTO.rates.cNY, favourite = false),
            Rate("JPY", value = rateDTO.rates.jPY, favourite = false),

            )
    }*/


}