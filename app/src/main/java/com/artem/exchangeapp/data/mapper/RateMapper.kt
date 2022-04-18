package com.artem.exchangeapp.data.mapper


import com.artem.exchangeapp.data.remote.modelDTO.CurrencyRatesDTO
import com.artem.exchangeapp.presentation.Rate

class RateMapper {

    fun mapRateDTOtoRate(rateDTO: CurrencyRatesDTO):List<Rate>{
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
    }



}