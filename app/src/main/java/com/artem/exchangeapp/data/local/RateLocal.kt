package com.artem.exchangeapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "savedRates"
)
data class RateLocal(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var name: String,
    var baseRate: String ,
    var value: Double ,
    var favourite: Boolean

)
