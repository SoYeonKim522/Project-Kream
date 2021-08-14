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

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
        HomeFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeButtonTryGetJwt.setOnClickListener {
            showLoadingDialog(requireContext())
            HomeService(this).tryGetUsers()
        }

        binding.homeBtnTryPostHttpMethod.setOnClickListener {
            val email = binding.homeEtId.text.toString()
            val password = binding.homeEtPw.text.toString()
            val postRequest = PostSignUpRequest(email = email, password = password,
                    confirmPassword = password, nickname = "test", phoneNumber = "010-0000-0000")
            showLoadingDialog(requireContext())
            HomeService(this).tryPostSignUp(postRequest)
        }

        binding.homeBtnTest.setOnClickListener {
            showCustomToast("test button click!")
        }

        binding.homeBtnSearch.setOnClickListener {
            val word = binding.homeEditText.text.toString()
            showLoadingDialog(requireContext())
            HomeService(this).tryGetUserSearch(word)
        }
    }

    ///이하의 함수들 호출은 서비스에서 함
    override fun onGetUserSuccess(response: UserResponse) {
        dismissLoadingDialog()
        for (User in response.result) {
            Log.d("HomeFragment", User.toString())
        }
        binding.homeButtonTryGetJwt.text = response.message
        showCustomToast("Get JWT 성공")
    }

    override fun onGetUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        binding.homeBtnTryPostHttpMethod.text = response.message
        response.message?.let { showCustomToast(it) }
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onGetUserSearchSuccess(response: UserSearchResponse) {
        dismissLoadingDialog()
        for (user in response.result){
            showCustomToast(user.email)
        }

    }

    override fun onGetUserSearchFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}