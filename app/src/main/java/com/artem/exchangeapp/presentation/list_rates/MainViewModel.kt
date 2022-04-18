package com.artem.exchangeapp.presentation.list_rates


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artem.exchangeapp.data.mapper.RateMapper
import com.artem.exchangeapp.data.remote.modelDTO.Rates
import com.artem.exchangeapp.domain.MainRepository
import com.artem.exchangeapp.presentation.Rate
import com.artem.exchangeapp.presentation.utils.DispatcherProvider
import com.artem.exchangeapp.presentation.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val SYMBOLS = "RUB,EUR,USD,BYN,PLN,GBP,KZT,ILS,CZK,AUD,BRL,HKD,IDR,CNY,JPY"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: DispatcherProvider

) : ViewModel() {

    sealed class CurrencyEvent {
        class Success(val listRates: List<Rate>) : CurrencyEvent()
        class Failure(val errorText: String) : CurrencyEvent()
        object Loading : CurrencyEvent()
        object Empty : CurrencyEvent()
    }

    private val _conversion = MutableStateFlow<CurrencyEvent>(CurrencyEvent.Empty)
    val conversion: StateFlow<CurrencyEvent> = _conversion

   /* private val _listRates = MutableStateFlow<Rates>()
    val listRates: StateFlow<CurrencyEvent> = _conversion*/

    fun convert(
        baseRate: String
    ) {


        viewModelScope.launch(dispatchers.io) {
            _conversion.value = CurrencyEvent.Loading
            val ratesResponse = repository.getRates(baseRate, SYMBOLS)
            when (ratesResponse) {
                is Resource.Error -> _conversion.value =
                    CurrencyEvent.Failure(ratesResponse.message!!)
                is Resource.Success -> {
                    val ratesDTO = ratesResponse.data!!
                    val listRate = RateMapper().mapRateDTOtoRate(ratesDTO)
                    _conversion.value = CurrencyEvent.Success(
                        listRate
                    )
                }
            }

            /*when(val ratesResponse = repository.getRates(baseRate,  SYMBOLS)) {
                is Resource.Error -> _conversion.value = CurrencyEvent.Failure(ratesResponse.message!!)
                is Resource.Success -> {
                    val rates = ratesResponse.data!!.rates
                    val rate = getRateForCurrency(baseRate, rates)
                    if(rate == null) {
                        _conversion.value = CurrencyEvent.Failure("Unexpected error")
                    } else {
                        val convertedCurrency = round(fromAmount * rate * 100) / 100
                        _conversion.value = CurrencyEvent.Success(
                            "$fromAmount $fromCurrency = $convertedCurrency $toCurrency"
                        )
                    }
                }
            }*/
        }
    }

    //https://api.exchangerate.host/latest?base=usd&symbols=RUB,EUR,USD,BYN,PLN,GBP,KZT,ILS,CZK,AUD,BRL,HKD,IDR,CNY,JPY
    private fun getRateForCurrency(currency: String, rates: Rates) = when (currency) {
        "RUB" -> rates.rUB
        "EUR" -> rates.hKD
        "USD" -> rates.uSD
        "BYN" -> rates.eUR
        "PLN" -> rates.pLN
        "GBP" -> rates.gBP
        "KZT" -> rates.kZT
        "ILS" -> rates.iLS
        "CZK" -> rates.cZK
        "AUD" -> rates.aUD
        "BRL" -> rates.bRL
        "HKD" -> rates.hKD
        "IDR" -> rates.iDR
        "CNY" -> rates.cNY
        "JPY" -> rates.jPY
        else -> null
    }

}