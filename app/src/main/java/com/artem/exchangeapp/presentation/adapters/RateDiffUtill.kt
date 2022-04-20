package com.artem.exchangeapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.artem.exchangeapp.presentation.Rate

class RateDiffUtill(
    private val oldList: List<Rate>,
    private val newList: List<Rate>,

    ) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }
            oldList[oldItemPosition].value != newList[newItemPosition].value -> {
                false
            }
            else -> true
        }
    }
}