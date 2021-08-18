package com.example.kream.kotlin.src.main.shop

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentShopBinding
import com.example.kream.kotlin.src.main.shop.models.*

class ShopFragment:BaseFragment<FragmentShopBinding> (FragmentShopBinding::bind, R.layout.fragment_shop), ShopView {

    private val TAG = "log"
    lateinit var viewFlipper:ViewFlipper


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        이미지 배너 슬라이드
        viewFlipper = binding.shopSlideBanner

        val images = intArrayOf(R.drawable.shop_banner2)
        for(image in images){
            val imageView = ImageView(requireContext())
            val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            imageView.layoutParams = layoutParams
            imageView.setImageResource(image)
            viewFlipper.flipInterval = 1000
            viewFlipper.isAutoStart=true

            viewFlipper.setInAnimation(requireContext(), android.R.anim.slide_in_left)
            viewFlipper.setOutAnimation(requireContext(), android.R.anim.slide_out_right)

        }

        //필터 버튼 토글 효과
        binding.shopFilterLuxury.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterSneakers.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterClothes.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterAcc.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterLife.setOnCheckedChangeListener(ToggleListener())
        binding.shopFilterTech.setOnCheckedChangeListener(ToggleListener())


        //카테고리 필터링 버튼 클릭 시 리사이클러뷰 변경
        binding.shopFilterSneakers.setOnClickListener{ ShopService(this).tryGetProductCategory("true", 0) }
        binding.shopFilterClothes.setOnClickListener { ShopService(this).tryGetProductCategory("true", 1) }
        binding.shopFilterAcc.setOnClickListener { ShopService(this).tryGetProductCategory("true", 2) }
        binding.shopFilterLife.setOnClickListener { ShopService(this).tryGetProductCategory("true", 3) }
        binding.shopFilterTech.setOnClickListener { ShopService(this).tryGetProductCategory("true", 4) }



        //상품 카테고리
//        val productList:ArrayList<ShopProductData> = arrayListOf(
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott dsfdsfsfsd", "2,000,000", "1,000", "50"),
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment", "2,000,000", "7,777", "123"),
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
//            ShopProductData(R.drawable.jordan_test, R.drawable.logo_jordan, "Jordan 1 x Travis Scott x Fragment...", "2,000,000", "7,777", "123"),
//
//            )

        ShopService(this).tryGetProducts()


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


    //세부카테고리 API
    override fun onGetProdCategorySuccess(response: CategoryResponse, index:Int) {
        showCategoryData(response.result.categoryList[index].detailCategoryList)
    }

        private fun showCategoryData(result: List<DetailCategory>){
            binding.shopRecyclerCategory.layoutManager = LinearLayoutManager(requireContext()).also { it.orientation = LinearLayoutManager.HORIZONTAL }
            val catAdapter = ShopCategoryAdapter(result, context)
            binding.shopRecyclerCategory.adapter = catAdapter
            binding.shopRecyclerCategory.setHasFixedSize(true)
            catAdapter.notifyDataSetChanged()
        }

    override fun onGetProdCategoryFailure(message: String) {
        showCustomToast("오류 : $message")
    }

    //전체 상품 가져오기 API
    override fun onGetProductSuccess(response: ProductResponse) {
        val result = response.result.productList
        binding.shopRecyclerProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        val prodAdapter = ShopProductAdapter(result, context)
        binding.shopRecyclerProduct.adapter = prodAdapter
        binding.shopRecyclerProduct.setHasFixedSize(true)
        prodAdapter.notifyDataSetChanged()
    }

    override fun onGetProductFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}