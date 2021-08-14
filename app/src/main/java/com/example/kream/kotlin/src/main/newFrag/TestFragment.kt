package com.example.kream.kotlin.src.main.newFrag

import android.os.Bundle
import android.view.View
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentTestBinding

class TestFragment: BaseFragment<FragmentTestBinding>(FragmentTestBinding::bind, R.layout.fragment_test) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showCustomToast("fragment success")
    }
}