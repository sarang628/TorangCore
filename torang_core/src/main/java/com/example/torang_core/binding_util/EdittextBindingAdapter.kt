package com.example.torang_core.binding_util

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("app:OnEditorAction")
fun onEditorAction(editText: EditText, unit: () -> Unit) {

    editText.setOnEditorActionListener { v, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            unit.invoke()
            true
        }
        false
    }
}