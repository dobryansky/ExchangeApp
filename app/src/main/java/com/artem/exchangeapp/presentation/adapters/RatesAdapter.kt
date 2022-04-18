package com.artem.exchangeapp.presentation.adapters

import android.provider.Telephony
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artem.exchangeapp.R
import com.artem.exchangeapp.databinding.ItemRecycleviewBinding
import com.artem.exchangeapp.presentation.Rate


class RatesAdapter : RecyclerView.Adapter<RatesAdapter.RatesViewHolder>() {

    var listRates: MutableList<Rate> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RatesViewHolder {
        return RatesViewHolder(
            ItemRecycleviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {

        holder.binding.apply {
            //txtCurrency.text = listRates[position].name
            txtCurrency.text = this.txtCurrency.resources.getString(
                R.string.currency_text,
                listRates[position].name
            )


            txtValue.text = listRates[position].value.toString()
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