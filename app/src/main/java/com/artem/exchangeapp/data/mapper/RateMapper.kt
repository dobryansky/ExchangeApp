package com.artem.exchangeapp.data.mapper

import com.artem.exchangeapp.data.remote.Rates
import com.artem.exchangeapp.data.remote.RatesDTO
import com.artem.exchangeapp.presentation.Rate

class RateMapper {

    fun mapDTOtoRateListModel(dto:RatesDTO):List<Rate>{
        return listOf(
            Rate("DKK", value = dto.rates.dKK, favourite = false),
            Rate("AED", value = dto.rates.aED, favourite = false),
            Rate("AFN", value = dto.rates.aFN, favourite = false),
            Rate("ALL", value = dto.rates.aLL, favourite = false),
            Rate("AMD", value = dto.rates.aMD, favourite = false),
            Rate("ANG", value = dto.rates.aNG, favourite = false),
            Rate("AOA", value = dto.rates.aOA, favourite = false),
            Rate("ARS", value = dto.rates.aRS, favourite = false),
            Rate("AUD", value = dto.rates.aUD, favourite = false),
            Rate("AWG", value = dto.rates.aWG, favourite = false),
            Rate("AZN", value = dto.rates.aZN, favourite = false),
            Rate("BAM", value = dto.rates.bAM, favourite = false),
            Rate("BBD", value = dto.rates.bBD, favourite = false),

        )
    }
}