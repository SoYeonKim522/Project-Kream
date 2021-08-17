package com.example.kream.kotlin.src.main.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentHomeBinding

///////////////(val image) 뺌
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home)
//        HomeFragmentView
{
//    private var currentPosition=0
//    val handler=Handler(Looper.getMainLooper()){
//        setPage()
//        true
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //최상단 칩
        binding.homeChipToday.isChecked=true
        binding.homeChipToday.setChipBackgroundColorResource(R.color.black_text)
        binding.homeChipReleasedInfo.setChipBackgroundColorResource(R.color.white)


        //슬라이딩 배너
        binding.viewpager.adapter = ViewPagerAdapter(getImageList())
//        val thread=Thread(PagerRunnable())
//        thread.start()


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

    //view pager 이미지 가져오기
    private fun getImageList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.home_banner1, R.drawable.home_banner2)
    }

    //view pager 페이지 변경
//    private fun setPage() {
//        if(currentPosition==5) currentPosition=0
//        binding.viewpager.setCurrentItem(currentPosition,true)
//        currentPosition+=1
//    }
//    inner class PagerRunnable:Runnable{
//        override fun run() {
//            while (true){
//                Thread.sleep(2000)
//                handler.sendEmptyMessage(0)
//            }
//        }
//    }



//    private inner class SlideViewPagerAdapter(frag: FragmentHomeBinding): SlideViewPagerAdapter(frag){
//        override fun getItemCount(): Int {
//        }
//
//        override fun createFragment(position: Int): Fragment {
//            return when(position){
//                0 -> HomeFragment(R.drawable.home_banner1)
//                1 -> HomeFragment(R.drawable.home_banner2)
//                else ->
//            }
//        }
//
//    }


}