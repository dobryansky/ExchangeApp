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
import com.artem.exchangeapp.databinding.FragmentListRatesBinding
import com.artem.exchangeapp.presentation.adapters.RatesAdapter
import com.artem.exchangeapp.presentation.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.migration.OptionalInject


@OptionalInject
@AndroidEntryPoint
class ListRatesFragment : BaseFragment<FragmentListRatesBinding>() {
    private val viewModel: MainViewModel by viewModels()
    private var adapter = RatesAdapter()
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListRatesBinding = FragmentListRatesBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecView()
        initSpinner()

        binding.btnPreferences.setOnClickListener {
            SortingFragment(object : ISortAnswer {
                override fun sortAnswer(sortMethod: SortMethod) {
                    sortMethodRate=sortMethod
                }
            }).show(parentFragmentManager, "")
        }

        lifecycleScope.launchWhenStarted {
            viewModel.conversion.collect { event ->
                when (event) {
                    is MainViewModel.CurrencyEvent.Success -> {
                        binding.progressBar.isVisible = false
                        adapter.listRates = event.listRates.toMutableList()
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
                        binding.spinnerChangeRate.selectedItem.toString(),
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
}


