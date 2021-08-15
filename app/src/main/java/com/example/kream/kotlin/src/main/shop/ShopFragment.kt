package com.example.kream.kotlin.src.main.shop

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentShopBinding

class ShopFragment:BaseFragment<FragmentShopBinding> (FragmentShopBinding::bind, R.layout.fragment_shop) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val TAG = "log"


        binding.shopFilterLuxury.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterSneakers.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterClothes.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterAcc.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterLife.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterTech.setOnCheckedChangeListener(ToggleListener())


        val productList:ArrayList<ShopProductData> = arrayListOf(
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),

            )

        binding.shopRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.shopRecyclerView.adapter = ShopProductAdapter(productList)
        binding.shopRecyclerView.setHasFixedSize(true)

    }

    inner class ToggleListener: CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if(isChecked){
                buttonView?.setBackgroundResource(R.drawable.shop_filter_button_clicked)
                buttonView?.setTextColor(Color.parseColor("#df614e"))
                binding.shopFilterIcon.setBackgroundResource(R.drawable.shop_filter_icon_clicked)
                Log.d("log", "${buttonView?.accessibilityClassName}")
                Log.d("log", "${buttonView?.id}")

            } else {
                buttonView?.setBackgroundResource(R.drawable.shop_filter_button_unclicked)
                buttonView?.setTextColor(Color.BLACK)
                binding.shopFilterIcon.setBackgroundResource(R.drawable.shop_filter_icon_unclicked)
            }
        }
    }





}