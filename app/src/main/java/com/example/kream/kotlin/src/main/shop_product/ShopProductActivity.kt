package com.example.kream.kotlin.src.main.shop_product

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityShopProductBinding
import com.example.kream.kotlin.src.main.BuyCheckActivity
import com.example.kream.kotlin.src.main.login.LoginActivity
import com.example.kream.kotlin.src.main.shop_product.models.*
import com.example.kream.kotlin.src.main.shop_product_by_size.ProdBySizeService
import com.example.kream.kotlin.src.main.shop_product_by_size.ProdSizeFragment
import com.example.kream.kotlin.src.main.shop_product_wishlist.ProdWishlistFragment
import kotlin.properties.Delegates


class ShopProductActivity : BaseActivity<ActivityShopProductBinding> (ActivityShopProductBinding::inflate), ProductView {

    private val TAG = "log"
    private val bottomSizeFrag = ProdSizeFragment()
    private val bottomWishlistFrag = ProdWishlistFragment()
    val jwt = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)
    lateinit var modelNo : String
    lateinit var prodName : String
    lateinit var imageURl : String
    lateinit var sellPrice : String

//    private val isWishlistAdded = intent.getBooleanExtra("isWishlistAdded", false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //data from ShopProductAdapter
        val productIdx = intent.getIntExtra("productIdx", 0)

        if(jwt==null){
            binding.loginLayout.isVisible = true
            binding.loginLayout.bringToFront()
        }

        //체결거래 탭 기본으로 선택 설정
        binding.salesBtn.isSelected=true
        if(productIdx!=0){
            //상품 상세 불러오기
            ProductService(this).tryGetProductDescription(productIdx)
            
            //체결 내역 보여주기
            ProductService(this).tryGetProductSales(productIdx)
            
            //추천상품 불러오기
            ProductService(this).tryGetRecommendation(productIdx)
        }


        //구매 사이즈 선택 시 - data from product size fragment
        supportFragmentManager.setFragmentResultListener("requestKey", this){requestKey, bundle ->
            val sizePassed = bundle.getString("chosenSize")
            val pricePassed = bundle.getInt("chosenPrice")
            val bidSaleIdx = bundle.getInt("bidSaleIdx").toString()
            val productSizeIdx = bundle.getInt("productSizeIdx")
            Log.d(TAG, "onCreate:bidSaleIdx 아이디 $bidSaleIdx ")  //0
            binding.sizeButton.text = sizePassed.toString()
            if(pricePassed!=0){
                binding.buyPrice.text = pricePassed.toString()
            } else {  //가격이 없을경우
                binding.buyPrice.text = "-"
                binding.sellPrice.text = "-"
                binding.latestPrice.text = "-"
                binding.priceChangeAmount.text = "-"
                binding.priceChangeRate.text ="-"
            }
            Log.d(TAG, "onCreate: 프래그먼트에서 받은 정보 $sizePassed  $pricePassed")


            if(sizePassed!=null){ //사이즈 선택된 경우
                Log.d(TAG, "onCreate: 사이즈 선택됨")
                binding.buyButton.setOnClickListener {
                    val intent = Intent(this, BuyCheckActivity::class.java)
                    intent.putExtra("size", sizePassed)
                    intent.putExtra("price", pricePassed)
                    intent.putExtra("prodName", prodName)
                    intent.putExtra("modelNo", modelNo)
                    intent.putExtra("imageUrl", imageURl)
                    intent.putExtra("sellPrice", sellPrice)
                    intent.putExtra("bidSaleIdx", bidSaleIdx)
                    intent.putExtra("productIdx", productIdx)
                    intent.putExtra("productSizeIdx", productSizeIdx)
//                    Log.d(TAG, "onCreate: 인텐트에 넣을 때 $sellPrice")
//                    Log.d(TAG, "onCreate: 데이터 패스 $sizePassed, $pricePassed, $prodName, $modelNo")
                    startActivity(intent)
                }
            }
        }

        //관심상품 추가 시
        supportFragmentManager.setFragmentResultListener("wishKey", this){requestKey, bundle ->
            val isWishAdded = bundle.getString("isWishAdded")
            if(isWishAdded=="added"){
                binding.wishlistIcon.setImageResource(R.drawable.wishlist_icon_clicked)
            }
        }

        //관심상품 추가 후
//        if(isWishlistAdded){
//            binding.wishlistIcon.setImageResource(R.drawable.wishlist_icon_clicked)
//        } else binding.wishlistIcon.setImageResource(R.drawable.wishlist_icon_black)


        //뒤로가기
        binding.backBtn.setOnClickListener {
            super.finish()
        }


    }


    override fun onGetProdDescriptionSuccess(response: ProductDescriptionResponse) {
        //상품 이미지 뷰페이저에 넘겨주기
        val imgResult = response.result.productImages
        binding.productImgViewPager.adapter = ProductImageAdapter(imgResult, this)

        val result = response.result
        binding.brandName.text = result.brandName
        binding.productName.text = result.name
        prodName = result.name
        modelNo = result.modelNo
        sellPrice = result.sellPrice.toString()
        Log.d(TAG, "onGetProdDescriptionSuccess:맨처음에 $sellPrice")
        imageURl = response.result.productImages[0].imageUrl
        binding.productNameKor.text = result.description
        binding.latestPrice.text = result.latestTransactedPrice.toString()+"원"
        binding.priceChangeAmount.text = result.priceIncreaseAmount.toString()
        binding.priceChangeRate.text = "("+result.priceIncreaseRate.toString()+"%)"
        binding.wishlishCount.text = result.liked.toString()
        if(result.sellPrice==null || result.sellPrice==0){
            binding.sellPrice.text = "-"
            sellPrice = result.sellPrice.toString()
            Log.d(TAG, "onGetProdDescriptionSuccess:맨처음에 $sellPrice")
        } else binding.sellPrice.text = result.sellPrice.toString()+"원"
        if(result.buyPrice==null || result.buyPrice==0){
            binding.buyPrice.text = "-"
        } else binding.buyPrice.text = result.buyPrice.toString()+"원"

            //가격 증가 감소에 따른 글자색, 아이콘 변경
            if(result.priceIncreaseAmount>0){
                binding.priceChangeIcon.setImageResource(R.drawable.prod_price_down_icon)
                binding.priceChangeAmount.setTextColor(R.color.prod_price_down.toInt())
                binding.priceChangeRate.setTextColor(R.color.prod_price_down.toInt())
            } else if(result.priceIncreaseAmount==0){
                binding.priceChangeIcon.visibility=View.INVISIBLE
                binding.priceChangeAmount.setTextColor(R.color.black.toInt())
                binding.priceChangeRate.setTextColor(R.color.black.toInt())
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

    override fun onGetSalesSuccess(response: SalesResponse) {
        val result = response.result.transactionList
        binding.tableRecycler.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.VERTICAL }
        binding.tableRecycler.adapter = SalesTableAdapter(result, this)
        binding.tableRecycler.setHasFixedSize(true)
    }

    override fun onGetSalesFailure(message: String) {
        Log.d(TAG, "onGetSalesFailure: $message")
    }

    override fun onGetAsksSuccess(response: AsksResponse) {
        val result = response.result.bidSaleList
        binding.tableRecycler.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.VERTICAL }
        binding.tableRecycler.adapter = AsksTableAdapter(result, this)
        binding.tableRecycler.setHasFixedSize(true)
    }

    override fun onGetAsksFailure(message: String) {
        Log.d(TAG, "onGetAsksFailure: $message")
    }

    override fun onGetBidsSuccess(response: BidsResponse) {
        val result = response.result.bidPurchaseList
        binding.tableRecycler.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.VERTICAL }
        binding.tableRecycler.adapter = BidsTableAdapter(result, this)
        binding.tableRecycler.setHasFixedSize(true)
    }

    override fun onGetBidsFailure(message: String) {
        Log.d(TAG, "onGetBidsFailure: $message")
    }

    override fun onGetRecSuccess(response: RecommendResponse) {
        binding.recommendTitle.text = response.result.brandName+"의 다른상품"
        val result = response.result.otherList
        binding.productRecRecyclerView.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        binding.productRecRecyclerView.adapter = RecommendAdapter(result, this)
        binding.productRecRecyclerView.setHasFixedSize(true)
    }

    override fun onGetRecFailure(message: String) {
        Log.d(TAG, "onGetRecFailure: $message")
    }

    //xml 에서 정의한 버튼 클릭 리스너
    fun tabClick(view: View) {
        val productIdx = intent.getIntExtra("productIdx", 0)
        Log.d(TAG, "tabClick: 아이디 $productIdx")
        val tabBtnList:List<Button> = listOf(binding.salesBtn, binding.asksBtn, binding.bidsBtn)
        for(btn in tabBtnList){
            btn.isSelected=false
            btn.setTypeface(null, Typeface.NORMAL)
        }
        view.isSelected=true
        when(view.id){
            R.id.sales_btn ->  {
                binding.salesSecondColumnHeader.text = "거래가"
                binding.salesThirdColumnHeader.text = "거래일"
                ProductService(this).tryGetProductSales(productIdx)
            }
            R.id.asks_btn -> {
                binding.salesSecondColumnHeader.text = "판매 희망가"
                binding.salesThirdColumnHeader.text = "수량"
                if(jwt!=null) {
                    ProductService(this).tryGetProductAsks(productIdx)
                } else {
                    binding.asksBtn.isEnabled = false
                    Log.d(TAG, "tabClick: 중간 탭 클릭 불가능")
                }
                
            }
            R.id.bids_btn -> {
                binding.salesSecondColumnHeader.text = "구매 희망가"
                binding.salesThirdColumnHeader.text = "수량"
                if(jwt!=null) {
                    ProductService(this).tryGetProductBids(productIdx)
                } else binding.bidsBtn.isEnabled = false
            }
        }
    }

    //xml 에서 정의. 사이즈별 구매/판매 가격 보여주는 버튼들
    fun showPriceBySizeButtonClick(view: View) {
        val productIdx = intent.getIntExtra("productIdx", 0)
        val bundle = Bundle()
        bundle.putInt("productIdx", productIdx)
        bundle.putInt("viewId", view.id)
        bottomSizeFrag.arguments = bundle
        bottomSizeFrag.show(supportFragmentManager, bottomSizeFrag.tag)
    }

    fun onWishlistClick(view: View) {
        val productIdx = intent.getIntExtra("productIdx", 0)
        val bundle = Bundle()
        bundle.putInt("productIdx", productIdx)
        bottomWishlistFrag.arguments = bundle
        bottomWishlistFrag.show(supportFragmentManager, bottomWishlistFrag.tag)


    }

    fun loginBtnClick(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }


}