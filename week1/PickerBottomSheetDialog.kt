package com.android.hara.presentation.custom

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.android.hara.R
import com.android.hara.databinding.FragmentBottomsheetPickerBinding
import com.android.hara.presentation.base.BindingNotDraggableBottomSheet
import dagger.hilt.android.AndroidEntryPoint

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


private const val MIN_CATEGORY_ID = 0

@AndroidEntryPoint
class PickerBottomSheetDialog(private val categoryPickerSelectedListener: (Int) -> Unit) :
    BindingNotDraggableBottomSheet<FragmentBottomsheetPickerBinding>(R.layout.fragment_bottomsheet_picker) {

    private val categoryGroups = listOf<String>("일상", "연애", "패션/뷰티", "커리어", "운동", "여행", "기타")
    private var categoryId = 1

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeCategoryPicker()
        setOnButtonsClickListener()
    }

    private fun initalizeCategoryPicker() {
        with(binding.pickerCategory) {
            displayedValues = categoryGroups.toTypedArray()
            minValue = MIN_CATEGORY_ID
            maxValue = categoryGroups.size - 1
            displayedValues = categoryGroups.toTypedArray()
            wrapSelectorWheel = true
            this.setOnValueChangedListener { _, _, nweCategoryId ->
                categoryId = nweCategoryId + 1
            }
        }
    }

    private fun setOnButtonsClickListener() {
        with(binding) {
            btnCancel.setOnClickListener {
                dismiss()
            }
            btnComplete.setOnClickListener {
                categoryPickerSelectedListener(categoryId)
                dismiss()
            }
        }
    }
}
