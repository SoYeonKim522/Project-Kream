package com.example.kream.kotlin.src.main.shop

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentShopBinding

class ShopFragment:BaseFragment<FragmentShopBinding> (FragmentShopBinding::bind, R.layout.fragment_shop) {

    lateinit var viewFlipper:ViewFlipper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val TAG = "log"

//        viewFlipper = binding.shopSlideBanner
//
//        val images = intArrayOf(R.drawable.shop_banner2)
//        for(image in images){
//            val imageView = ImageView(requireContext())
//            val layoutParams = FrameLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//            imageView.layoutParams = layoutParams
//            imageView.setImageResource(image)
//            viewFlipper.flipInterval = 1000
//            viewFlipper.isAutoStart=true
//
//            viewFlipper.setInAnimation(requireContext(), android.R.anim.slide_in_left)
//            viewFlipper.setOutAnimation(requireContext(), android.R.anim.slide_out_right)
//
//        }


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