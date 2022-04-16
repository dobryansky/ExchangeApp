package com.artem.exchangeapp.presentation.list_rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.artem.exchangeapp.databinding.FragmentListRatesBinding
import com.artem.exchangeapp.presentation.adapters.RatesAdapter
import com.artem.exchangeapp.presentation.utils.BaseFragment

class ListRatesFragment : BaseFragment<FragmentListRatesBinding>() {
    private var adapter = RatesAdapter()
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListRatesBinding = FragmentListRatesBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecView()
    }

    private fun initRecView() {
        binding.apply {
            recView.layoutManager = LinearLayoutManager(context)
            recView.adapter = adapter
        }

    }
}