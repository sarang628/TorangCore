package com.example.torang_core.util

import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import com.example.torang_core.data.model.HoursOfOperation
import java.util.*

@BindingAdapter("bindHoursOfOperation")
fun bindHoursOfOperation(
    viewGroup: ViewGroup,
    hoursOfOperationBodies: ArrayList<HoursOfOperation?>?
) {
    viewGroup.removeAllViewsInLayout()
    if (hoursOfOperationBodies != null) for (i in hoursOfOperationBodies.indices) {
        //viewGroup.addView(HoursOfOperationFactory.getView(viewGroup.getContext(), hoursOfOperationBodies.get(i)));
    }
}

@BindingAdapter("bindMenus")
fun bindMenus(viewGroup: ViewGroup, menuBodies: ArrayList<Menu?>?) {
    viewGroup.removeAllViewsInLayout()
    if (menuBodies != null) for (i in menuBodies.indices) {
        //viewGroup.addView(MenuFactory.getView(viewGroup.getContext(), menuBodies.get(i)));
    }
}


@BindingAdapter("select")
fun select(v: View?, b: Boolean?) {
    if (v != null && b != null) v.isSelected = b
}