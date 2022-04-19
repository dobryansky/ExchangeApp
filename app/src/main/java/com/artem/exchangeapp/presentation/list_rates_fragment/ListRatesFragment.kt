package com.artem.exchangeapp.presentation.list_rates_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.coroutines.flow.collect
import androidx.recyclerview.widget.LinearLayoutManager
import com.artem.exchangeapp.data.mapper.RateMapper
import com.artem.exchangeapp.databinding.FragmentListRatesBinding
import com.artem.exchangeapp.presentation.adapters.RatesAdapter
import com.artem.exchangeapp.presentation.dialog_fragment.SortingFragment
import com.artem.exchangeapp.presentation.utils.BaseFragment
import com.artem.exchangeapp.presentation.utils.SortingRates
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.migration.OptionalInject
import kotlin.properties.Delegates.notNull


@OptionalInject
@AndroidEntryPoint
class ListRatesFragment : BaseFragment<FragmentListRatesBinding>() {
    private val viewModel: MainViewModel by viewModels()
    private var sortMethod by notNull<Int>()
    private var adapter = RatesAdapter()
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListRatesBinding = FragmentListRatesBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecView()
        initSpinner()
        setupSortingFragmentListener()
        initBtnPref()
        observe()
        sortMethod = savedInstanceState?.getInt(SORT_VOLUME) ?: 1
    }

    private fun initBtnPref() {
        binding.btnPreferences.setOnClickListener {
            showSortingFragment()
        }
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            viewModel.conversion.collect { event ->
                when (event) {
                    is MainViewModel.CurrencyEvent.Success -> {
                        binding.progressBar.isVisible = false

                        val listRates = RateMapper().mapRateDTOtoRate(event.listRates)
                        val sortRates = SortingRates(sortMethod, listRates).sort()
                        adapter.listRates = sortRates.toMutableList()
                        adapter.notifyDataSetChanged()
                        print("123")
                    }
                    is MainViewModel.CurrencyEvent.Failure -> {
                        binding.progressBar.isVisible = false
                    }
                    is MainViewModel.CurrencyEvent.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun initSpinner() {
        binding.spinnerChangeRate.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.convert(
                        binding.spinnerChangeRate.selectedItem.toString()
                    )
                }
            }
    }

    private fun initRecView() {
        binding.apply {
            recView.layoutManager = LinearLayoutManager(context)
            recView.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
            recView.adapter = adapter
        }
    }


    private fun showSortingFragment() {
        SortingFragment.show(parentFragmentManager, sortMethod)
    }

    private fun setupSortingFragmentListener() {
        SortingFragment.setupListener(parentFragmentManager, this) {
            this.sortMethod = it
            viewModel.convert(binding.spinnerChangeRate.selectedItem.toString())
            binding.txtSortMethod.text = when (sortMethod) {
                1 -> "ALPHABET UP"
                2 -> "ALPHABET DOWN"
                3 -> "VALUE UP"
                4 -> "VALUE DOWN"
                else -> "ALPHABET UP"
            }
        }
    }

    companion object {
        private val TAG = ListRatesFragment::class.java.simpleName
        private val SORT_VOLUME = "SORT_VOLUME"
    }




}


