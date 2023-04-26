package com.android.hara.presentation.custom

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.android.hara.R
import com.android.hara.databinding.FragmentBottomsheetPickerBinding
import com.android.hara.presentation.base.BindingNotDraggableBottomSheet
import com.android.hara.presentation.util.HARAobjcet.categoryList
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/*
        binding.clCategorySelectLayout.setOnSingleClickListener {
            PickerBottomSheetDialog() { categoryViewModel.setCategory(it) }.show(
                childFragmentManager,
                "picker"
            )
        }
        호출부 부분 
        addListener는 해당 호출부에서 고차함수 형태로 넘겨집니다.
*/


@AndroidEntryPoint
class PickerBottomSheetDialog(private val addListener: (Int) -> Unit) :
    BindingNotDraggableBottomSheet<FragmentBottomsheetPickerBinding>(R.layout.fragment_bottomsheet_picker) {

    companion object{    
        val categoryList = listOf<String>("일상", "연애", "패션/뷰티", "커리어", "운동", "여행", "기타")
    }
            
    private var count = 1

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setOnClickListener()
    }

    private fun init() {
        with(binding.pickerCategory) {
            displayedValues = categoryList.toTypedArray()
            minValue = 0
            maxValue = categoryList.size - 1
            displayedValues = categoryList.toTypedArray()
            wrapSelectorWheel = true //
        }
    }

    private fun setOnClickListener() {
        binding.pickerCategory.setOnValueChangedListener { picker, xoldVal, newVal ->
            Timber.e(count.toString())
            count = newVal + 1
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        binding.btnComplete.setOnClickListener {
            addListener(count)
            dismiss()
        }
    }
}
