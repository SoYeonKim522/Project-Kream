package com.example.kream.kotlin.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentHomeBinding
import com.example.kream.kotlin.src.main.home.models.PostSignUpRequest
import com.example.kream.kotlin.src.main.home.models.SignUpResponse
import com.example.kream.kotlin.src.main.home.models.UserResponse
import com.example.kream.kotlin.src.main.home.models.UserSearchResponse

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home)
//        HomeFragmentView
{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //최상단 칩
        binding.homeChipToday.isChecked=true
        binding.homeChipToday.setChipBackgroundColorResource(R.color.black_text)
        binding.homeChipReleasedInfo.setChipBackgroundColorResource(R.color.white)


        //슬라이딩 배너
        //val image = ArrayList<>

//
//        binding.homeBtnTryPostHttpMethod.setOnClickListener {
//            val email = binding.homeEtId.text.toString()
//            val password = binding.homeEtPw.text.toString()
//            val postRequest = PostSignUpRequest(email = email, password = password,
//                    confirmPassword = password, nickname = "test", phoneNumber = "010-0000-0000")
//            showLoadingDialog(requireContext())
//            HomeService(this).tryPostSignUp(postRequest)
//        }
//
//        binding.homeBtnTest.setOnClickListener {
//            showCustomToast("test button click!")
//        }
//
//        binding.homeBtnSearch.setOnClickListener {
//            val word = binding.homeEditText.text.toString()
//            showLoadingDialog(requireContext())
//            HomeService(this).tryGetUserSearch(word)
//        }
//    }
//


    }

}