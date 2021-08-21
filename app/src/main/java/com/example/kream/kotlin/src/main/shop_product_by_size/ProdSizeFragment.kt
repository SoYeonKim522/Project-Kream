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
import com.example.kream.kotlin.src.main.shop_product_by_size.models.SellPriceBySizeResponse
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

//BaseFragment<FragmentProdSizeBinding>(FragmentProdSizeBinding::bind, R.layout.fragment_prod_size),

class ProdSizeFragment: BottomSheetDialogFragment(), ProdBySizeView{
    private var mBinding: FragmentProdSizeBinding? =null
    private val  binding  get()  = mBinding!!
    private val TAG = "log"
    private var isSizeButton:Boolean = true

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

        //구매버튼 눌렀을 때 or 사이즈 선택버튼 눌렀을 때
        val productIdx = arguments?.getInt("productIdx")
        val buttonId = arguments?.getInt("viewId")
        Log.d(TAG, "onCreateView 전달된 아이디: $productIdx")
        Log.d(TAG, "onCreateView: 버튼 아이디 $buttonId")

        //사이즈 선택 버튼 눌렀을 때
        if(buttonId==2131296745){
            if (productIdx!=null || productIdx==0){
                ProdBySizeService(this).tryGetBuyPriceBySize(productIdx)
            } else Log.d(TAG, "PRODUCT SIZE BOTTOM FRAG: ERROR - productIdx값 null")
        }

        //구매 버튼 눌렀을 때
        if(buttonId==2131296382){
            isSizeButton=false
            if (productIdx!=null || productIdx==0){
                ProdBySizeService(this).tryGetBuyPriceBySize(productIdx)
            } else Log.d(TAG, "PRODUCT SIZE BOTTOM FRAG: ERROR - productIdx값 null")
        }

        //판매 버튼 눌렀을 때
        if (buttonId==2131296714){
            if (productIdx!=null || productIdx==0){
                ProdBySizeService(this).tryGetSellPriceBySize(productIdx)
                binding.tvPrice.text="즉시 판매가(원)"
            } else Log.d(TAG,"PRODUCT SIZE BOTTOM FRAG: ERROR - productIdx_sell값 null")
        }


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
        var result = response.result

        val listSize = result.size
        val newResult = result.subList(1,listSize)  //구매버튼 눌렀을 때 전달할 데이터 리스트

        if(!isSizeButton){
           result=newResult
        }
        val sizeAdapter = BuyPriceAdapter(result, context)
        binding.priceBySizeRecycler.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.priceBySizeRecycler.adapter = sizeAdapter
        binding.priceBySizeRecycler.setHasFixedSize(true)
        sizeAdapter.notifyDataSetChanged()
        isSizeButton=true
    }

    override fun onGetBuyPriceBySizeFailure(message: String) {
        Log.d(TAG, "onGetBuyPriceBySizeFailure: $message")
    }

    override fun onGetSellPriceBySizeSuccess(response: SellPriceBySizeResponse) {
        //이 버튼들을 같은 클릭 리스너로 구현하지 않으면 (따로따로 setonclick-을 설정하면)
        // ShopProductActivity 에서 productIdx 가 default value 인 0 을 전달받게 되어 result 가 null -> npe 발생함
        val result = response.result

        val sellPriceAdapter = SellPriceAdapter(result, context)
        Log.d(TAG, "onGetSellPriceBySizeSuccess결과: $result")

        binding.priceBySizeRecycler.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.priceBySizeRecycler.adapter = sellPriceAdapter
        binding.priceBySizeRecycler.setHasFixedSize(true)
        sellPriceAdapter.notifyDataSetChanged()
    }

    override fun onGetSellPriceBySizeFailure(message: String) {
        Log.d(TAG, "onGetSellPriceBySizeFailure: $message")
    }


//    override fun onItemClick(view: View) {
//        Log.d(TAG, "onItemClick: 사이즈 버튼 클릭")
//        dialog?.dismiss()
//    }


}