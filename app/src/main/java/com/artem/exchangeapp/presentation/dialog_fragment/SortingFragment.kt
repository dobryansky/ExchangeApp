package com.artem.exchangeapp.presentation.dialog_fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.artem.exchangeapp.databinding.FragmentSortingDialogBinding

class SortingFragment(private val question: String, val answer: IConfirmChanges) :
    DialogFragment() {
    private lateinit var binding: FragmentSortingDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortingDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.confirmText.text = question
        initButtonListeners()

    }

    private fun initButtonListeners() {
        binding.btnNegative.setOnClickListener {
            answer.negativeAnswer()
            dismiss()
        }
        binding.btnPozitive.setOnClickListener {
            answer.pozitiveAnswer()
            dismiss()
        }
    }

    companion object {
        const val TAG = "ConfirmChangesDialog"
        fun newInstance(question: String, answer: IConfirmChanges): SortingFragment {
            return SortingFragment(question, answer)
        }
    }

}

interface IConfirmChanges {
    fun pozitiveAnswer()
    fun negativeAnswer()
}