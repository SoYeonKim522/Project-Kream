package com.example.kream.kotlin.src.main

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivitySettingBinding

class SettingActivity:BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {
    val TAG = "log"
    val jwt = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.logoutBtn.setOnClickListener {
        val logoutDialog = LogoutDialog(this)
        logoutDialog.showLogoutDialog()
        }

        binding.backBtn.setOnClickListener {
            super.finish()
        }


    }



}