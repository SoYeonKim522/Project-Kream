package com.example.kream.kotlin.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentMyPageBinding
import com.example.kream.kotlin.src.main.login.LoginActivity
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity

class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page) {

    val jwt = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)
    val TAG = "log"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: 마이페이지 시작")

        if(jwt==null){
            showCustomToast("로그인이 안되어있음")
            //로그인 액티비티 실행
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
       } else {
            Log.d(TAG, "onCreate: 로그인이 되어 있는 경우")
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            Log.d("log", "마이페이지 지우기 전: $jwt")
        
        //최상단 칩
        binding.myShoppingChip.isChecked=true
        binding.myShoppingChip.setChipBackgroundColorResource(R.color.black_text)
        binding.myProfileChip.setChipBackgroundColorResource(R.color.white)


        binding.logoutBtn.setOnClickListener {

            ApplicationClass.editor.remove(ApplicationClass.X_ACCESS_TOKEN)
            ApplicationClass.editor.commit()
            Log.d("log", "마이페이지 로그아웃 후: $jwt")
            showCustomToast("로그아웃 완료")

            binding.myNickname.text = ""
            binding.myName.text = ""
            binding.myBio.text = ""


        }
    }
}