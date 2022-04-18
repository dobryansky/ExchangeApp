package com.artem.exchangeapp.presentation.dialog_fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.artem.exchangeapp.R
import com.artem.exchangeapp.databinding.FragmentSortingDialogBinding
import com.artem.exchangeapp.presentation.list_rates_fragment.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.migration.OptionalInject

@OptionalInject
@AndroidEntryPoint
class SortingFragment() :
    DialogFragment() {
    private lateinit var binding: FragmentSortingDialogBinding
    private val sortMethod: Int
        get() = requireArguments().getInt(ARG_SORT_METHOD)

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
        initRadioGroupButtons()

    }

    private fun initRadioGroupButtons() {
     //   sortMethod=requireArguments().getInt(ARG_SORT_METHOD)

       when (sortMethod){
           1-> binding.radioButton1.isChecked=true
           2-> binding.radioButton2.isChecked=true
           3-> binding.radioButton3.isChecked=true
           4-> binding.radioButton4.isChecked=true
       }
        binding.radioGroupSort.setOnCheckedChangeListener { group, checkedId ->
               val sortMethod = when(checkedId){
                    R.id.radioButton1 -> 1
                    R.id.radioButton2 -> 2
                    R.id.radioButton3 -> 3
                    R.id.radioButton4 -> 4
                    else -> 0
                }
            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(SORT_METHOD_RESPONSE to sortMethod))

        }
        binding.button.setOnClickListener {
            dismiss()

        }
    }

    companion object {
        private val TAG = SortingFragment::class.java.simpleName
        private val SORT_METHOD_RESPONSE = "SORT_METHOD_RESPONSE"
        private val ARG_SORT_METHOD = "ARG_SORT_METHOD"
        val REQUEST_KEY = "$TAG:defaultRequestKey"


        fun show(manager: FragmentManager, sortMethod: Int) {
            val dialogFragment = SortingFragment()
            dialogFragment.arguments = bundleOf(ARG_SORT_METHOD to sortMethod)
            dialogFragment.show(manager, TAG)
        }

        fun setupListener(
            manager: FragmentManager,
            lifecycleOwner: LifecycleOwner,
            listener: (Int) -> Unit
        ) {
            manager.setFragmentResultListener(
                REQUEST_KEY,
                lifecycleOwner,
                FragmentResultListener { _, result ->
                    listener.invoke(result.getInt(SORT_METHOD_RESPONSE))
                })
        }
    }

}

