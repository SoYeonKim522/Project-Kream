package com.example.kream.kotlin.src.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityMainBinding
import com.example.kream.kotlin.src.main.home.HomeFragment
import com.example.kream.kotlin.src.main.login.LoginActivity
import com.example.kream.kotlin.src.main.shop.ShopFragment
import com.example.kream.kotlin.src.main.shop.ShopService
import com.example.kream.kotlin.src.main.shop.ShopView
import com.example.kream.kotlin.src.main.style.StyleFragment
import com.example.kream.kotlin.src.main.watch.WatchFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)


        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_style -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, StyleFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_shop -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ShopFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_watch -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, WatchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_my -> {
                        startActivity(Intent(this, LoginActivity::class.java))
                        return@OnNavigationItemSelectedListener true
                    }

                    //로그인 되어 있을 때
//                    R.id.menu_main_btm_nav_my -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(R.id.main_frm, MyPageFragment())
//                            .commitAllowingStateLoss()
//                        return@OnNavigationItemSelectedListener true
//                    }


                }
                false
            })


        binding.mainBtmNav
    }

}