package com.example.kream.kotlin.src.main.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.InputType.*
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityLoginBinding
import com.example.kream.kotlin.src.main.MainActivity
import com.example.kream.kotlin.src.main.login.models.LoginResponse
import com.example.kream.kotlin.src.main.login.models.PostLoginRequest
import com.example.kream.kotlin.src.main.signUp.SignUpActivity
import java.util.regex.Pattern

class LoginActivity : BaseActivity<ActivityLoginBinding> (ActivityLoginBinding::inflate), LoginView {
    private val TAG = "log"
    private var emailChecked = false
    private var pwChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.loginBtnGoSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        binding.backBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        //이메일 형식 검사
        val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        fun checkEmail():Boolean{
            var email = binding.loginEtEmail.text.toString().trim()
            val validate = Pattern.matches(emailValidation, email)
            if(validate || email.isEmpty()){
                binding.email.setTextColor(Color.parseColor("#000000"))
                binding.loginEtEmail.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.black)
                binding.wrongEmail.visibility=View.INVISIBLE
                emailChecked = true
                activateLogin(emailChecked, pwChecked)
                return true
            } else {
                binding.email.setTextColor(Color.parseColor("#df6250"))
                binding.loginEtEmail.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.red_invalid)
                binding.wrongEmail.visibility=View.VISIBLE
                emailChecked=false
                activateLogin(emailChecked, pwChecked)
                return false
            }
        }
        binding.loginEtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.loginEtEmail.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.black)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmail()
            }
            override fun afterTextChanged(s: Editable?) {
            }

        })


        //비밀번호 형식 검사
        val passwordValidation = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&]).{8,12}.\$"
        fun checkPassword():Boolean{
            var password = binding.loginEtPassword.text.toString().trim()
            val validate = Pattern.matches(passwordValidation, password)
            if(validate || password.isEmpty()){
                binding.password.setTextColor(Color.parseColor("#000000"))
                binding.loginEtPassword.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.black)
                binding.wrongPassword.visibility= View.INVISIBLE
                pwChecked = true
                activateLogin(emailChecked, pwChecked)
                return true
            } else {
                binding.password.setTextColor(Color.parseColor("#df6250"))
                binding.loginEtPassword.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.red_invalid)
                binding.wrongPassword.visibility= View.VISIBLE
                pwChecked=false
                activateLogin(emailChecked, pwChecked)
                return false
            }
        }
        binding.loginEtPassword.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.loginEtPassword.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.black)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkPassword()
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        //비밀번호 show & hide
        binding.loginPasswordToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.loginPasswordToggle.setBackgroundResource(R.drawable.login_show_password)
                binding.loginEtPassword.inputType = TYPE_CLASS_TEXT
            } else {
                binding.loginPasswordToggle.setBackgroundResource(R.drawable.login_hide_password)
                binding.loginEtPassword.inputType = TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        //로그인 함수 호출
        binding.loginBtnLogin.setOnClickListener {
            val email = binding.loginEtEmail.text.toString()
            val password = binding.loginEtPassword.text.toString()
            val postRequest = PostLoginRequest(email, password)
            LoginService(this).tryPostLogin(postRequest)
        }

    }



    private fun activateLogin(emailChecked: Boolean, pwChecked: Boolean) {
        if (this.emailChecked && this.pwChecked) {
            Log.d(TAG, "onCreate: 가입하기 활성화")
            binding.loginBtnLogin.setBackgroundResource(R.drawable.login_button_clicked)
            binding.loginBtnLogin.isClickable = true
        } else{
            binding.loginBtnLogin.setBackgroundResource(R.drawable.login_button)
            binding.loginBtnLogin.isClickable = false
        }
    }

    override fun onPostLoginSuccess(response: LoginResponse) {
        Log.d(TAG, "onPostSignUpSuccess: ${response.result}")
        showCustomToast("로그인 완료")
        ApplicationClass.editor.putString(ApplicationClass.X_ACCESS_TOKEN, response.result.token)
        ApplicationClass.editor.commit()
//        startActivity(Intent(this, MainActivity::class.java))
//        finish()
    }

    override fun onPostLoginFailure(message: String) {
        showCustomToast("오류 : $message")
    }


}