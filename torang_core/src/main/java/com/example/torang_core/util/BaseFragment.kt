package com.example.torang_core.util

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.torang_core.util.Logger.v

open class BaseFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        v(javaClass.simpleName)
    }

    override fun onDetach() {
        super.onDetach()
        v(javaClass.simpleName)
    }
}