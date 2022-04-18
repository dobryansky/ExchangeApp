package com.artem.exchangeapp.data.remote.modelDTO


import com.google.gson.annotations.SerializedName

data class CurrencyRatesDTO(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("motd")
    val motd: Motd,
    @SerializedName("rates")
    val rates: Rates,
    @SerializedName("success")
    val success: Boolean
)