package com.example.kream.kotlin.src.main.loginActivity

import android.content.Intent
import android.os.Bundle
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityLoginBinding
import com.example.kream.kotlin.databinding.ActivitySignupBinding
import com.example.kream.kotlin.src.main.signUpActivity.SignUpActivity

class LoginActivity : BaseActivity<ActivityLoginBinding> (ActivityLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginBtnGoSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

    }
}