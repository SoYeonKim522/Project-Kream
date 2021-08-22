package com.example.kream.kotlin.src.main.myPage

import android.os.Bundle
import android.view.View
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentMyPageBinding

class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //최상단 칩
        binding.myShoppingChip.isChecked=true
        binding.myShoppingChip.setChipBackgroundColorResource(R.color.black_text)
        binding.myProfileChip.setChipBackgroundColorResource(R.color.white)


    }
}