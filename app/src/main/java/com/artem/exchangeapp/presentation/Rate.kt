package com.artem.exchangeapp.presentation

data class Rate(
    var name: String,
    var baseRate: String ="USD",
    var value: Double ,
    var favourite: Boolean
)


