package com.example.kream.kotlin.src.main.signUp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivitySignupBinding
import com.example.kream.kotlin.src.main.MainActivity
import com.example.kream.kotlin.src.main.login.LoginActivity
import com.example.kream.kotlin.src.main.signUp.models.PostSignUpRequest
import com.example.kream.kotlin.src.main.signUp.models.SignUpResponse
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignupBinding> (ActivitySignupBinding::inflate), SignUpView {
    private val TAG = "log"
    private var emailChecked = false
    private var pwChecked = false
    private var boxChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.backBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        //이메일 형식 검사
        val emailValidation =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

        fun checkEmail(): Boolean {
            var email = binding.signUpEtEmail.text.toString().trim()
            val validate = Pattern.matches(emailValidation, email)
            if (validate || email.isEmpty()) {
                binding.email.setTextColor(Color.parseColor("#000000"))
                binding.signUpEtEmail.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.black)
                binding.wrongEmail.visibility= View.INVISIBLE
                if(validate && email.isNotEmpty()){
                    emailChecked = true
                }
                activateSignUp(emailChecked, pwChecked, boxChecked)
                return true
            } else {
                binding.email.setTextColor(Color.parseColor("#df6250"))
                binding.signUpEtEmail.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.red_invalid)
                binding.wrongEmail.visibility= View.VISIBLE
                emailChecked=false
                activateSignUp(emailChecked, pwChecked, boxChecked)
                return false
            }
        }
        binding.signUpEtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.signUpEtEmail.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.black)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmail()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        //비밀번호 형식 검사
        val passwordValidation = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&]).{8,12}.\$"
        fun checkPassword(): Boolean {
            var password = binding.signUpEtPassword.text.toString().trim()
            val validate = Pattern.matches(passwordValidation, password)
            if (validate || password.isEmpty()) {
                binding.password.setTextColor(Color.parseColor("#000000"))
                binding.signUpEtPassword.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.black)
                binding.wrongPassword.visibility= View.INVISIBLE
                if(validate&&password.isNotEmpty()){
                    pwChecked = true
                }
                activateSignUp(emailChecked, pwChecked, boxChecked)
                return true
            } else {
                binding.password.setTextColor(Color.parseColor("#df6250"))
                binding.signUpEtPassword.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.red_invalid)
                binding.wrongPassword.visibility= View.VISIBLE
                pwChecked=false
                activateSignUp(emailChecked, pwChecked, boxChecked)
                return false
            }
        }

        binding.signUpEtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.signUpEtPassword.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.black)
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
                binding.signUpEtPassword.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.loginPasswordToggle.setBackgroundResource(R.drawable.login_hide_password)
                binding.signUpEtPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        // 필수 체크항목 체크여부
        binding.checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                boxChecked=true
                activateSignUp(emailChecked, pwChecked, boxChecked)
            } else {
                boxChecked=false
                activateSignUp(emailChecked, pwChecked, boxChecked)
            }


            //회원 가입 함수 호출
            binding.signupButton.setOnClickListener {
                val email = binding.signUpEtEmail.text.toString()
                val password = binding.signUpEtPassword.text.toString()
                val postRequest = PostSignUpRequest(
                    email = email, password = password,
                    name = "김소연", phone = "01038901091"
                )
                showLoadingDialog(this)
                SignUpService(this).tryPostSignUp(postRequest)
            }


//        binding.signUpEtPassword.onFocusChangeListener = object :View.OnFocusChangeListener{
//            override fun onFocusChange(v: View?, hasFocus: Boolean) {
//                if(hasFocus){
//                    binding.signUpEtEmail.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.black)
//                } else binding.signUpEtEmail.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.gray_text)
//
//            }
//        }

//        if(binding.checkBox1.isChecked){
//            Log.d(TAG, "onCreate: 체크됨")
//            binding.signupButton.setBackgroundColor(Color.parseColor("#222222"))
//        }

        }

    }


    private fun activateSignUp(emailChecked: Boolean, pwChecked: Boolean, boxChecked: Boolean) {
        if (this.emailChecked && this.pwChecked && this.boxChecked) {
            //Log.d(TAG, "onCreate: 가입하기 활성화")
            binding.signupButton.setBackgroundResource(R.color.black_text)
            binding.signupButton.isClickable = true
        } else {
            binding.signupButton.setBackgroundResource(R.drawable.login_button)
            binding.signupButton.isClickable = false
        }
    }


    override fun onPostSignUpSuccess(signUpResponse: SignUpResponse) {
        Log.d(TAG, "onPostSignUpSuccess: ${signUpResponse.code}")
        when(signUpResponse.code){
            1000->{
//                showCustomToast("가입이 완료되었습니다")
                super.finish()  //이전 화면으로 돌아가기
                dismissLoadingDialog()
            }
            3013->{showCustomToast("이미 등록된 이메일입니다")
                dismissLoadingDialog()}
            3015->{showCustomToast("이미 등록된 휴대폰 번호입니다")
                dismissLoadingDialog()}
            else->{showCustomToast("회원가입 실패")
                dismissLoadingDialog()}
        }
    }

    override fun onPostSignUpFailure(s: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $s")
    }
}