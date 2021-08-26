package com.example.kream.kotlin.src.main.shop_product_wishlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kream.kotlin.databinding.FragmentProdAddWishlistBinding
import com.example.kream.kotlin.databinding.FragmentProdSizeBinding
import com.example.kream.kotlin.src.main.shop_product_by_size.BuyPriceAdapter
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishRequest
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.WishResponse
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

        //AddWishlistAdapter 인터페이스 호출
        wishlistAdapter.setOnWishClickListener(object :AddWishlistAdapter.OnWishClickListener{
            override fun onWishClick(view: View, productSizeIdx: Int) {
                //관심상품 추가되었는지 여부 상품상세에 전달
                val bundle = bundleOf("isWishAdded" to "added")
                setFragmentResult("wishKey", bundle)
                val request = AddWishRequest(productSizeIdx)
                ProdWishlistService(this@ProdWishlistFragment).tryPostWishlist(productSizeIdx, request)
                Log.d(TAG, "onWishClick: $request")
            }
        })

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

    override fun onGetWishlistSuccess(response: WishResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetWishlistFailure(message: String) {
        TODO("Not yet implemented")
    }


}