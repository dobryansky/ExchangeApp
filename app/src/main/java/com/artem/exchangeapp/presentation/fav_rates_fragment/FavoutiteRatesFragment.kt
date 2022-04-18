package com.artem.exchangeapp.presentation.fav_rates_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artem.exchangeapp.databinding.FragmentFavouriteRatesBinding
import com.artem.exchangeapp.presentation.utils.BaseFragment

class FavouriteRatesFragment : BaseFragment<FragmentFavouriteRatesBinding>() {
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavouriteRatesBinding =
        FragmentFavouriteRatesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}