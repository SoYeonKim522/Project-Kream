package com.example.kream.kotlin.src.main.style

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentStyleBinding
import com.example.kream.kotlin.src.main.style.models.StyleResponse

class StyleFragment: BaseFragment<FragmentStyleBinding>(FragmentStyleBinding::bind, R.layout.fragment_style), StyleView {

    private val TAG = "log"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //최상단 칩
        binding.trendingChip.isChecked=true
        binding.trendingChip.setChipBackgroundColorResource(R.color.black_text)
        binding.followingChip.setChipBackgroundColorResource(R.color.white)

        StyleService(this).tryGetStyle()
    }

    override fun onGetStyleSuccess(response: StyleResponse) {
        val result = response.result.styleList
        Log.d(TAG, "onGetStyleSuccess: $result")
        val styleAdapter = StyleAdapter(result, context)
        binding.styleRecycler.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.styleRecycler.adapter = styleAdapter
        binding.styleRecycler.setHasFixedSize(true)
        styleAdapter.notifyDataSetChanged()
    }

    override fun onGetStyleFailure(message: String) {
        Log.d(TAG, "onGetStyleFailure: $message")
        showCustomToast("오류 : $message")
    }


}