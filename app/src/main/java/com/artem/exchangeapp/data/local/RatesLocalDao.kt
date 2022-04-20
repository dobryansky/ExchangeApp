package com.artem.exchangeapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.MutableStateFlow


@Dao
interface RatesLocalDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(rateLocal: RateLocal): Long


    @Query("SELECT * FROM savedRates")
    fun getAllSavedRates(): List<RateLocal>

    @Delete
    suspend fun deleteSavedRate(rateLocal: RateLocal)
}