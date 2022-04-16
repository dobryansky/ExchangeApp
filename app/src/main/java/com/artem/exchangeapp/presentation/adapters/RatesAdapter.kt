package com.artem.exchangeapp.presentation.adapters

import android.provider.Telephony
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artem.exchangeapp.databinding.ItemRecycleviewBinding
import com.artem.exchangeapp.presentation.Rate
import com.artem.exchangeapp.presentation.getRates


class RatesAdapter : RecyclerView.Adapter<RatesAdapter.RatesViewHolder>() {

    private var listRates: MutableList<Rate> = getRates()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RatesAdapter.RatesViewHolder {
        return RatesViewHolder(
            ItemRecycleviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {

        holder.binding.apply {
            txtCurrency.text = listRates[position].name
            txtValue.text = listRates[position].cost.toString()
            favButton.isChecked = listRates[position].favourite
        }

    }

    override fun getItemCount(): Int {
        return listRates.size
    }


    class RatesViewHolder(val binding: ItemRecycleviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}