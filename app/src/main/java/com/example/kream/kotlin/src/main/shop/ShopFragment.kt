package com.example.kream.kotlin.src.main.shop

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentShopBinding
import com.example.kream.kotlin.src.main.shop.models.*
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity
import com.example.kream.kotlin.src.main.shop_product_wishlist.ProdWishlistService
import com.example.kream.kotlin.src.main.shop_product_wishlist.ProdWishlistView
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.WishResponse
import kotlin.properties.Delegates


class ShopFragment:BaseFragment<FragmentShopBinding> (FragmentShopBinding::bind, R.layout.fragment_shop), ShopView{

    private val TAG = "log"
    lateinit var viewFlipper:ViewFlipper
    val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, "")
    var productIdx by Delegates.notNull<Int>()


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
            viewFlipper.flipInterval = 2000
            viewFlipper.isAutoStart=true

            viewFlipper.setInAnimation(requireContext(), android.R.anim.slide_in_left)
            viewFlipper.setOutAnimation(requireContext(), android.R.anim.slide_out_right)

        }


        //필터 버튼 토글 효과
        val catBtnList= arrayListOf(binding.shopFilterSneakers, binding.shopFilterClothes, binding.shopFilterAcc, binding.shopFilterLife, binding.shopFilterTech)
        var clickedCatList = arrayListOf<ToggleButton>()

        for(btn in catBtnList){
            btn.setOnClickListener {
                for(btns in catBtnList){
                    btns.setBackgroundResource(R.drawable.shop_filter_button_unclicked)
                    btns.setTextColor(Color.BLACK)
                    btns.isSelected=false
                    clickedCatList.remove(btns)
//                    Log.d(TAG, "onViewCreated: 지운 다음 배열 갯수 ${clickedCatList.size}")
                }
                btn.isSelected=true
                clickedCatList.add(btn)
//                Log.d(TAG, "onViewCreated: 배열 갯수 ${clickedCatList.size}")
                btn.setBackgroundResource(R.drawable.shop_filter_button_clicked)
                btn.setTextColor(Color.parseColor("#df614e"))
                when(btn.id){
                    R.id.shop_filter_sneakers -> ShopService(this).tryGetProductCategory("true", 0)
                    R.id.shop_filter_clothes -> ShopService(this).tryGetProductCategory("true", 1)
                    R.id.shop_filter_acc -> ShopService(this).tryGetProductCategory("true", 2)
                    R.id.shop_filter_life -> ShopService(this).tryGetProductCategory("true", 3)
                    R.id.shop_filter_tech -> ShopService(this).tryGetProductCategory("true", 4)
                }

                if (clickedCatList.size==0){
                    ShopService(this).tryGetProductCategory("true", 0)
                    binding.shopFilterIcon.setBackgroundResource(R.drawable.shop_filter_icon_unclicked)
                } else {
                    binding.shopFilterIcon.setBackgroundResource(R.drawable.shop_filter_icon_clicked)
                }

            }
        }


        //초기화면 세부 카테고리 불러오기
        ShopService(this).tryGetProductCategory("true", 0)
        //초기화면 전체 상품 리스트 불러오기
        ShopService(this).tryGetProducts()
        showLoadingDialog(requireContext())

        //관심상품 불러오기
//        ProdWishlistService(this).tryGetWishlist(userIdx=userIdx!!.toInt())

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
        dismissLoadingDialog()
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
        dismissLoadingDialog()
    }

    //전체 상품 가져오기 API
    override fun onGetProductSuccess(response: ProductResponse) {
        val result = response.result.productList
        val prodAdapter = ShopProductAdapter(result, context)
        binding.shopRecyclerProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.shopRecyclerProduct.adapter = prodAdapter
        binding.shopRecyclerProduct.setHasFixedSize(true)
        prodAdapter.notifyDataSetChanged()
        dismissLoadingDialog()

        productIdx = result[0].idx
    }

    override fun onGetProductFailure(message: String) {
        showCustomToast("오류 : $message")
        dismissLoadingDialog()
    }

    //관심상품
//    override fun onGetWishlistSuccess(response: WishResponse) {
//        val resultSize = response.result.size
//        val wishAdded = setOf<Int>()
//        Log.d(TAG, "onGetWishlistSuccess: 결과 사아이즈 $resultSize")
//        for (i in 0..resultSize) {
//            val result = response.result[i].productSizeIdx
//
//        }
//    }

//    override fun onGetWishlistFailure(message: String) {
//        Log.d(TAG, "onGetWishlistFailure 오류 : $message")
//    }
//
//    override fun onGetAllSizeListSuccess(response: SizeResponse) {
//    }
//
//    override fun onGetAllSizeListFailure(message: String) {
//    }
//
//    override fun onPostWishlistSuccess(response: AddWishResponse) {
//    }
//
//    override fun onPostWishlistFailure(message: String) {
//    }



}