package com.artem.exchangeapp.presentation.list_rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artem.exchangeapp.databinding.FragmentListRatesBinding
import com.artem.exchangeapp.presentation.utils.BaseFragment

class ListRatesFragment : BaseFragment<FragmentListRatesBinding>() {
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListRatesBinding = FragmentListRatesBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}