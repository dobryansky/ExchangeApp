package com.artem.exchangeapp.presentation.list_rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.artem.exchangeapp.data.mapper.RateMapper
import com.artem.exchangeapp.data.remote.RetrofitInstance
import com.artem.exchangeapp.databinding.FragmentListRatesBinding
import com.artem.exchangeapp.presentation.Rate
import com.artem.exchangeapp.presentation.adapters.RatesAdapter
import com.artem.exchangeapp.presentation.utils.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListRatesFragment : BaseFragment<FragmentListRatesBinding>() {
    private var newList = mutableListOf<Rate>()
    private var adapter = RatesAdapter()
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListRatesBinding = FragmentListRatesBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecView()

        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch() {
            val rates = RetrofitInstance.apiService.getRates()
            if(rates.success) {
                newList = RateMapper().mapDTOtoRateListModel(rates).toMutableList()
            }
            print("1121")
        }


    }

    private fun initRecView() {
        binding.apply {
            recView.layoutManager = LinearLayoutManager(context)
            adapter.listRates=newList
            recView.adapter = adapter
        }
    }
}


