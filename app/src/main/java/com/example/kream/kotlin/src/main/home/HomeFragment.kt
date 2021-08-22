package com.example.kream.kotlin.src.main.home

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.module.AppGlideModule
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.databinding.FragmentHomeBinding
import com.example.kream.kotlin.src.main.home.models.*

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) , HomeFragmentView {

    private val TAG = "log"
    private var currentPosition = 0
    private var viewPagerHandler = ViewPagerHandler()
    private val intervalTime = 2000.toLong()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //최상단 칩
        binding.homeChipToday.isChecked=true
        binding.homeChipToday.setChipBackgroundColorResource(R.color.black_text)
        binding.homeChipReleasedInfo.setChipBackgroundColorResource(R.color.white)

        //자동 슬라이드 배너
        HomeService(this).tryGetMainBanner()

        //테마별 상품 추천
        HomeService(this).tryGetThemeProduct()

        //특정 상품 광고 이미지
        HomeService(this).tryGetAdImage()


        //STYLE PICKS
        val stylePicksList:List<SpData> = listOf(
            SpData(R.drawable.home_style_1),
            SpData(R.drawable.home_style_1),
            SpData(R.drawable.home_style_1),
        )
        binding.homeStylePicksRecycler.layoutManager = LinearLayoutManager(requireContext()).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        binding.homeStylePicksRecycler.adapter = HomeStylePicksAdapter(stylePicksList)
        binding.homeStylePicksRecycler.setHasFixedSize(true)
    }



    //테마별 상품
    override fun onGetThemeProductSuccess(response: ThemeProductResponse) {
        val recyclerList = arrayListOf<RecyclerView>(binding.homeJustDroppedRecycler, binding.homeMostPopRecycler, binding.homeOffWhiteRecycler, binding.homeNewInRecycler, binding.homeStreetWearRecycler, binding.homeSmallLeathersRecycler, binding.homeContemporaryRecycler, binding.homeLuxurySneakersRecycler, binding.homeLowestAsksRecycler, binding.homeHighestBidsRecycler, binding.homeUpcomingReleaseRecycler, binding.homeLegoRecycler, binding.homeKorCollectionRecycler, binding.homeOrcaAltRecycler, binding.homeGreyCollectRecycler)

        var i = 0
        for (recycler in recyclerList) {
            for (i in i..i) {
                recycler.layoutManager = LinearLayoutManager(requireContext()).also {
                    it.orientation = LinearLayoutManager.HORIZONTAL
                }
                recycler.adapter = HomeJustDroppedAdapter(response.result[i].productList)
                recycler.setHasFixedSize(true)
            }
            i++
        }

    }

    override fun onGetThemeProductFailure(message: String) {
        Log.d(TAG, "onGetThemeProductFailure: $message")
    }

    override fun onGetMainBannerSuccess(response: MainBannerResponse) {
        val result = response.result
        binding.mainBannerViewpager.adapter = ViewPagerAdapter(result, context)  //리스트 뷰페이저 어댑터에 넘기기

        //자동 슬라이드
        binding.mainBannerViewpager.setCurrentItem(currentPosition, false)
        binding.mainBannerViewpager.apply {
            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state){
                        ViewPager2.SCROLL_STATE_IDLE -> autoSlideStart(intervalTime)
                    }
                }
            })
        }
    }

    private fun autoSlideStart(intervalTime: Long) {
        viewPagerHandler.removeMessages(0)
        viewPagerHandler.sendEmptyMessageDelayed(0, intervalTime)
    }

    private inner class ViewPagerHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what == 0){
                binding.mainBannerViewpager.setCurrentItem(++currentPosition, true)
                autoSlideStart(intervalTime)
            }
        }
    }

    override fun onGetMainBannerFailure(message: String) {
        Log.d(TAG, "onGetMainBannerFailure: $message")
    }


    //광고 상품 이미지
    override fun onGetAdImageSuccess(response: AdImageResponse) {

        val imageViewList = arrayListOf<ImageView>(binding.adImage1, binding.adImage2, binding.adImage3, binding.adImage4, binding.adImage5, binding.adImage6, binding.adImage7, binding.adImage8, binding.adImage9, binding.adImage10, binding.adImage11, binding.adImage12, binding.adImage13)

        for ((i, iv) in imageViewList.withIndex()){
            for(i in i..i){
                Glide.with(this).load(response.result[i].image).error(R.drawable.login_button).into(iv)
            }
            Log.d(TAG, "onGetAdImageSuccess: $i")
        }
    }

    override fun onGetAdImageFailure(message: String) {
        Log.d(TAG, "onGetAdImageFailure: $message")
    }


    override fun onResume() {
        super.onResume()
        autoSlideStart(intervalTime)
    }

    override fun onPause() {
        super.onPause()
        viewPagerHandler.removeMessages(0)  //핸들러 중지
    }
}