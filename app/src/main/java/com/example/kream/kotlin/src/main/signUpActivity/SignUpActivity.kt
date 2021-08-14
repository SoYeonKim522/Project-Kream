package com.example.kream.kotlin.src.main.signUpActivity

import android.content.Intent
import android.os.Bundle
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivitySignupBinding
import com.example.kream.kotlin.src.main.loginActivity.LoginActivity

class SignUpActivity : BaseActivity<ActivitySignupBinding> (ActivitySignupBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.backBtn.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}