package com.artem.exchangeapp.presentation.list_rates_fragment


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artem.exchangeapp.data.mapper.RateMapper
import com.artem.exchangeapp.data.remote.modelDTO.Rates
import com.artem.exchangeapp.domain.MainRepository
import com.artem.exchangeapp.presentation.Rate
import com.artem.exchangeapp.presentation.utils.DispatcherProvider
import com.artem.exchangeapp.presentation.utils.Resource
import com.artem.exchangeapp.presentation.utils.SortMethod
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


        }
    }


    }

    //https://api.exchangerate.host/latest?base=usd&symbols=RUB,EUR,USD,BYN,PLN,GBP,KZT,ILS,CZK,AUD,BRL,HKD,IDR,CNY,JPY


