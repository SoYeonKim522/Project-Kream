package com.example.kream.kotlin.src.main.shop_product_by_size

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.databinding.FragmentProdSizeBinding
import com.example.kream.kotlin.src.main.shop_product_by_size.models.BuyPriceBySizeResponse
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//BaseFragment<FragmentProdSizeBinding>(FragmentProdSizeBinding::bind, R.layout.fragment_prod_size),

class ProdSizeFragment: BottomSheetDialogFragment(), ProdBySizeView{
    private var mBinding: FragmentProdSizeBinding? =null
    private val  binding  get()  = mBinding!!
    private val TAG = "log"


//    private val productIdx = arguments?.getInt("productIdx")

    //슬라이드 애니메이션 -- doesn't work
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getDialog()?.getWindow()?.getAttributes()?.windowAnimations = R.style.bottomFragAnimation

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentProdSizeBinding.inflate(inflater,  container, false)

        val productIdx = arguments?.getInt("productIdx")
        //Log.d(TAG, "onCreateView 전달된 아이디: $productIdx")
        if (productIdx!=null){
            ProdBySizeService(this).tryGetBuyPriceBySize(productIdx)
        } else Log.d(TAG, "PRODUCT SIZE BOTTOM FRAG: ERROR - productIdx값 null")


        binding.closeBtn.setOnClickListener {
            dialog?.dismiss()
        }

        //ProdSizeAdapter 의 인터페이스 호출!!!
//        val sizeList= listOf<SizeResult>()
//        val prodSizeAdapter = ProdSizeAdapter(sizeList, context)
//        prodSizeAdapter.setOnSizeClickListener(object : ProdSizeAdapter.OnSizeClickListener{
//            override fun onSizeClick(view: View) {
//                Log.d(TAG, "onItemClick: 사이즈 버튼 클릭")
//                dialog?.dismiss()
//            }
//        })


        return binding.root
    }




    override fun onGetBuyPriceBySizeSuccess(response: BuyPriceBySizeResponse) {
        val result = response.result

        val sizeAdapter = BuyPriceAdapter(result, context)
        binding.priceBySizeRecycler.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.priceBySizeRecycler.adapter = sizeAdapter
        binding.priceBySizeRecycler.setHasFixedSize(true)
        sizeAdapter.notifyDataSetChanged()



    }

    override fun onGetBuyPriceBySizeFailure(message: String) {
        Log.d(TAG, "onGetBuyPriceBySizeFailure: $message")
    }


//    override fun onItemClick(view: View) {
//        Log.d(TAG, "onItemClick: 사이즈 버튼 클릭")
//        dialog?.dismiss()
//    }


}