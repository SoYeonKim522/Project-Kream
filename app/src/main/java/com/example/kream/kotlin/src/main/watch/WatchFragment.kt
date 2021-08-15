package com.example.kream.kotlin.src.main.watch

import android.os.Bundle
import android.view.View
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentWatchBinding

class WatchFragment:BaseFragment<FragmentWatchBinding> (FragmentWatchBinding::bind, R.layout.fragment_watch) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showCustomToast("watch")
    }
}