package com.artem.exchangeapp.presentation.utils

import com.artem.exchangeapp.presentation.Rate

class SortingRates {

    fun sortAlphabetAscending(list: List<Rate>): List<Rate> {
        val sortedList = list
        return sortedList.sortedBy { rate ->
            rate.name
        }
    }

    fun sortAlphabetDescending(list: List<Rate>): List<Rate> {
        val sortedList = list
        return sortedList.sortedByDescending { rate ->
            rate.name
        }
    }

    fun sortValueAscending(list: List<Rate>): List<Rate> {
        val sortedList = list
        return sortedList.sortedByDescending { rate ->
            rate.value
        }
    }

    fun sortValueDescending(list: List<Rate>): List<Rate> {
        val sortedList = list
        return sortedList.sortedByDescending { rate ->
            rate.value
        }
    }

}