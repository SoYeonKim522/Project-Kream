package com.example.kream.kotlin.src.main.shop_product_wishlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kream.kotlin.databinding.FragmentProdAddWishlistBinding
import com.example.kream.kotlin.databinding.FragmentProdSizeBinding
import com.example.kream.kotlin.src.main.shop_product_by_size.BuyPriceAdapter
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishRequest
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeResponse
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProdWishlistFragment : BottomSheetDialogFragment(), ProdWishlistView {
    private var mBinding: FragmentProdAddWishlistBinding? =null
    private val  binding  get()  = mBinding!!
    private val TAG = "log"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentProdAddWishlistBinding.inflate(inflater,  container, false)

        //api 불러오기
        val productIdx = arguments?.getInt("productIdx")
        ProdWishlistService(this).tryGetAllSizeList(productIdx!!)

        //닫기 버튼
        binding.closeBtn.setOnClickListener {
            dialog?.dismiss()
        }

        //관심상품 추가 api 호출
//        val productSizeIdx = intent 에서 불러오기 from addwishlist adapter
//        val addWishRequest = AddWishRequest(productSizeIdx)
//        ProdWishlistService(this).tryPostWishlist(productIdx, addWishRequest)


        return binding.root
    }

    override fun onGetAllSizeListSuccess(response: SizeResponse) {
        val result = response.result.sizeList

        val wishlistAdapter = AddWishlistAdapter(result, context)
        binding.addWishlistRecycler.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.addWishlistRecycler.adapter = wishlistAdapter
        binding.addWishlistRecycler.setHasFixedSize(true)
        wishlistAdapter.notifyDataSetChanged()
    }

    override fun onGetAllSizeListFailure(message: String) {
        Log.d(TAG, "onGetAllSizeListFailure: $message")
    }

    override fun onPostWishlistSuccess(response: AddWishResponse) {
        Toast.makeText(context, "관심상품 추가", Toast.LENGTH_SHORT).show()
    }

    override fun onPostWishlistFailure(message: String) {
        Log.d(TAG, "onPostWishlistFailure: $message")
    }


}