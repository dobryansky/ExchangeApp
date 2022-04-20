package com.artem.exchangeapp.presentation

data class Rate(
    var id: Int,
    var name: String,
    var baseRate: String ="USD",
    var value: Double ,
    var favourite: Boolean
)


