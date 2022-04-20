package com.artem.exchangeapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [RateLocal::class],
    version = 1
)

//@TypeConverters(Converters::class)
abstract class RatesDatabase: RoomDatabase() {

    abstract fun getRateLocalDao():RatesLocalDao

    companion object {
        @Volatile
        private var instance: RatesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RatesDatabase::class.java,
                "rate_db.db"
            ).build()
    }
}