package com.artem.exchangeapp.data


import com.artem.exchangeapp.data.remote.CurrencyAPI
import com.artem.exchangeapp.data.remote.modelDTO.CurrencyRatesDTO
import com.artem.exchangeapp.domain.MainRepository
import com.artem.exchangeapp.presentation.utils.Resource
import java.lang.Exception
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: CurrencyAPI
) : MainRepository {
    override suspend fun getRates(base: String, symbols: String): Resource<CurrencyRatesDTO> {
        return try {
            val response = api.getRates(base, symbols)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)

            } else {
                Resource.Error(response.message())
            }

        } catch (e: Exception) {
            Resource.Error(e.message ?: "Something went wrong")
        }
    }
}