package com.artem.exchangeapp.presentation.utils

import com.artem.exchangeapp.presentation.Rate

class SortingRates(val sortMethod: Int, val list: List<Rate>) {

    fun sort(): List<Rate> {

        return when (sortMethod) {
            1 -> return sortAlphabetAscending()
            2 -> return sortAlphabetDescending()
            3 -> return sortValueAscending()
            4 -> return sortValueDescending()
            else -> {
                sortAlphabetAscending()
            }
        }
    }


    fun sortAlphabetAscending(): List<Rate> {
        val sortedList = list
        return sortedList.sortedBy { rate ->
            rate.name
        }
    }

    fun sortAlphabetDescending(): List<Rate> {
        val sortedList = list
        return sortedList.sortedByDescending { rate ->
            rate.name
        }
    }

    fun sortValueAscending(): List<Rate> {
        val sortedList = list
        return sortedList.sortedBy { rate ->
            rate.value
        }
    }

    fun sortValueDescending(): List<Rate> {
        val sortedList = list
        return sortedList.sortedByDescending { rate ->
            rate.value
        }
    }

}