package com.example.kream.kotlin.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentMyPageBinding
import com.example.kream.kotlin.src.main.SettingActivity
import com.example.kream.kotlin.src.main.login.LoginActivity
import com.example.kream.kotlin.src.main.myPage.models.UserInfoResponse
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity

class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page), MyPageView {

    val jwt = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)
    val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, null)
    val TAG = "log"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(jwt==null){
//            showCustomToast("로그인이 안되어있음")
            //로그인 액티비티 실행
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
       } else {
            Log.d(TAG, "onCreate: 로그인이 되어 있는 경우")
            MyPageService(this).tryGetUserInfo(userIdx!!)
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            Log.d("log", "마이페이지 jwt 지우기 전: $jwt")
        
        //최상단 칩
        binding.myShoppingChip.isChecked=true
        binding.myShoppingChip.setChipBackgroundColorResource(R.color.black_text)
        binding.myProfileChip.setChipBackgroundColorResource(R.color.white)

        //설정 창 띄우기
        binding.mySettingIcon.setOnClickListener {
            val intentS = Intent(requireContext(), SettingActivity::class.java)
            startActivity(intentS)
        }

//        binding.logoutBtn.setOnClickListener {
//
//            ApplicationClass.editor.remove(ApplicationClass.X_ACCESS_TOKEN)
//            ApplicationClass.editor.commit()
//            Log.d("log", "마이페이지 로그아웃 후: $jwt")
//            showCustomToast("로그아웃 완료")
//
//            binding.myNickname.text = ""
//            binding.myName.text = ""
//            binding.myBio.text = ""
//        }


    }

    override fun onTryGetUserInfoSuccess(response: UserInfoResponse) {
        val result = response.result
        val nickname = result.nickName
        val name = result.name
        val bio = result.introduction
        val wishCnt = result.productLikeCount
        val totalBuy = result.purchaseBiddingCount+result.purchaseProceedingCount+result.purchaseCompletedCount
        val currentBuy = result.purchaseBiddingCount
        val pendingBuy = result.purchaseProceedingCount
        val historyBuy = result.purchaseCompletedCount

        binding.myNickname.text = nickname
        binding.myName.text = name
        binding.myBio.text = bio
        binding.myWishlistCnt.text = wishCnt.toString()
        binding.myBuyingTotalCnt.text = totalBuy.toString()
        binding.myBuyingCurrentCnt.text = currentBuy.toString()
        binding.myBuyingPendingCnt.text = pendingBuy.toString()
        binding.myBuyingHistoryCnt.text = historyBuy.toString()

    }

    override fun onTryGetUserInfoFailure(message: String) {
        Log.d(TAG, "onTryGetUserInfoFailure: $message")

    }
}