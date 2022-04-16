package com.artem.exchangeapp.presentation

data class Rate(
    val name: String = "USD",
    val cost: Long = 12L,
    val favourite: Boolean
)

fun getRates():MutableList<Rate>{
    return mutableListOf(
        Rate(favourite = true),
        Rate(favourite = false),
        Rate(favourite = true),
        Rate(favourite = false),
        Rate(favourite = true),
        Rate(favourite = true),
        Rate(favourite = false),
        Rate(favourite = true),
        Rate(favourite = false),
        Rate(favourite = true),
        Rate(favourite = false),
        Rate(favourite = false),
        Rate(favourite = false),
        Rate(favourite = false),
        Rate(favourite = false),
        Rate(favourite = false),
        Rate(favourite = false),
        Rate(favourite = false)
    )
}
