package com.example.kream.kotlin.src.main.style

import android.os.Bundle
import android.view.View
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentStyleBinding

class StyleFragment: BaseFragment<FragmentStyleBinding>(FragmentStyleBinding::bind, R.layout.fragment_style) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showCustomToast("fragment success")
    }
}