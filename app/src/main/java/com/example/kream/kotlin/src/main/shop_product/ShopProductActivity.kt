package com.example.kream.kotlin.src.main.shop_product

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ShopProductBinding
import com.example.kream.kotlin.src.main.shop_product.models.ProductDescriptionResponse


class ShopProductActivity : BaseActivity<ShopProductBinding> (ShopProductBinding::inflate), ProductView {

    private val TAG = "log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1번 상품 상세 불러오기
        ProductService(this).tryGetProductDescription(1)

    }

//    private fun getImageList(): List<Int> {
//        return listOf(R.drawable.jordan_test, R.drawable.home_banner2, R.drawable.home_banner1)
//    }

    override fun onGetProdDescriptionSuccess(response: ProductDescriptionResponse) {
        //상품 이미지 뷰페이저에 넘겨주기
        val imgResult = response.result.productImages
        binding.productImgViewPager.adapter = ProductImageViewpagerAdapter(imgResult, this)

        val result = response.result
        binding.brandName.text = result.brandName
        binding.productName.text = result.name
        binding.productNameKor.text = result.description
        binding.latestPrice.text = result.latestTransactedPrice.toString()+"원"
        binding.priceChangeAmount.text = result.priceIncreaseAmount.toString()
        binding.priceChangeRate.text = "("+result.priceIncreaseRate.toString()+"%)"
        binding.wishlishCount.text = result.liked.toString()
        binding.sellPrice.text = result.sellPrice.toString()+"원"
        binding.buyPrice.text = result.buyPrice.toString()+"원"

            //가격 증가 감소에 따른 글자색, 아이콘 변경
            if(result.priceIncreaseAmount>0){
                binding.priceChangeIcon.setImageResource(R.drawable.prod_price_down_icon)
                binding.priceChangeAmount.setTextColor(R.color.prod_price_down.toInt())
                binding.priceChangeRate.setTextColor(R.color.prod_price_down.toInt())
            }

        //리사이클러뷰에 넘겨줄 상품정보 리스트 따로 만들기
        val prodInfoList:MutableList<String> = mutableListOf()  //빈리스트 선언
        prodInfoList.add(response.result.modelNo)
        prodInfoList.add(response.result.releaseDate)
        prodInfoList.add(response.result.color)
        prodInfoList.add(response.result.releasePrice.toString())

        //상품 정보 리스트 리사이클러뷰에 넘겨주기
        binding.prodDescriptionRecycler.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        binding.prodDescriptionRecycler.adapter = ShopProdInfoAdapter(prodInfoList, this)
        binding.prodDescriptionRecycler.setHasFixedSize(true)
    }


    override fun onGetProdDescriptionFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d(TAG, "onGetProdDescriptionFailure: $message")
    }


}