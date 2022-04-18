package com.artem.exchangeapp.presentation

data class Rate(
    val name: String = "USD",
    val baseRate: String = "EUR",
    val value: Double = 12.0,
    val favourite: Boolean = false
)


