package com.example.kream.kotlin.src.main.address

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityAddAddressBinding
import com.example.kream.kotlin.src.main.buy_now.BuyNowActivity
import com.example.kream.kotlin.src.main.address.models.AddAddressResponse
import com.example.kream.kotlin.src.main.address.models.PostAddressRequest
import java.util.regex.Pattern

class AddAddressActivity:BaseActivity<ActivityAddAddressBinding>(ActivityAddAddressBinding::inflate), AddAddressActivityView {

    private val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, "")
    private val TAG = "log"

    private var phoneNoChecked = false
    private var restChecked = false

    private var primaryCheck = "FALSE"
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activateSaveBtn(phoneNoChecked, restChecked)

        val phoneNoValidation = "\\d{11}"

        fun checkPhoneNo(): Boolean {
            var phoneNo = binding.etPhoneNo.text.toString()
            val validate = Pattern.matches(phoneNoValidation, phoneNo)
            if (validate || phoneNo.isEmpty()){
                binding.tvPhoneNo.setTextColor(Color.parseColor("#000000"))
                binding.etPhoneNo.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.black)
                if(validate && phoneNo.isNotEmpty()){
                    phoneNoChecked = true
                    binding.wrongPhone.visibility= View.INVISIBLE
                }
                activateSaveBtn(phoneNoChecked, restChecked)
                return true
            } else {
                binding.tvPhoneNo.setTextColor(Color.parseColor("#df6250"))
                binding.etPhoneNo.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.red_invalid)
                phoneNoChecked = false
                binding.wrongPhone.visibility= View.VISIBLE
                activateSaveBtn(phoneNoChecked, restChecked)
                return false
            }
        }

        binding.etPhoneNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.etPhoneNo.backgroundTintList =
                    ContextCompat.getColorStateList(applicationContext, R.color.black)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkPhoneNo()
            }
            override fun afterTextChanged(s: Editable?) {
            }

        })

        //et를 어레이에 넣고 for문 안에서 text watcher 사용하는 것으로 변경하기
        val dataList = arrayListOf<String>(binding.etName.toString(), binding.etPostCode.toString(), binding.etAddress.toString(), binding.etAddress2.toString())
        for (data in dataList){
            if(data!=null && data.isNotEmpty()){
                restChecked = true
            }
        }





//        if(name!=null && phoneNo!=null && postCode!=null && address1!=null && address2!=null){
//            Log.d(TAG, "onCreate: 저장 버튼 활성화")
//            binding.saveAddressBtn.setBackgroundResource(R.drawable.login_button_clicked)
//            binding.saveAddressBtn.isClickable = true
//            binding.saveAddressBtn.isEnabled = true
//        } else {
//            Log.d(TAG, "onCreate: 저장 버튼 비활-")
//            binding.saveAddressBtn.setBackgroundResource(R.drawable.login_button)
//            binding.saveAddressBtn.isClickable = false
//        }

        binding.saveAddressBtn.setOnClickListener {

            //입력받은 데이터
            val name = binding.etName.text.toString()
            val phoneNo = binding.etPhoneNo.text.toString()
            val postCode = binding.etPostCode.text.toString()
            val address1 = binding.etAddress.text.toString()
            val address2 = binding.etAddress2.text.toString()

            binding.setPrimaryCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked){
                    primaryCheck = "TRUE"
                } else primaryCheck = "FALSE"
            }

            Log.d(TAG, "onCreate: 클릭!!!")
            val postRequest = PostAddressRequest(address = address1, addressDetail = address2, defaultAddress = primaryCheck, name = name, phone = phoneNo, zipCode = postCode)
            Log.d(TAG, "주소 저장 버튼 눌렀을때 :  $postRequest")  //works

            //api 함수 호출
            AddAddressService(this).tryPostAddress(userIdx!!.toInt(), postRequest)
            //데이터 전달 -- X  (api 통해 조회하는걸로 하기)
//            val intent = Intent(this, BuyNowActivity::class.java)
//            val intent = Intent()
//            intent.putExtra("name", name)
//            intent.putExtra("phoneNo", phoneNo)
//            intent.putExtra("postCode", postCode)
//            intent.putExtra("address1", address1)
//            intent.putExtra("address2", address2)
//            intent.putExtra("primaryCheck", primaryCheck)
//            startActivity(intent)
//            setResult(RESULT_OK, intent)
//            startActivityForResult(intent, 1)


            //finish()  //-> 즉시구매하기 화면에서 주문상품 데이터 유지함

        }

        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onPostAddressSuccess(response: AddAddressResponse) {
        Log.d(TAG, "onPostAddressSuccess 주소 api : $response")
        if(response.code==1000){
            showCustomToast("추가 완료")
            val result = response.result
            ApplicationClass.editor.putString("addressName", result.name).apply()
            ApplicationClass.editor.putInt("addressIdx", result.idx).apply()
//            val intent = Intent(this, BuyNowActivity::class.java)
//            intent.putExtra("name", result.name)
//            intent.putExtra("addressIdx", result.idx)  //start activity 를 하는게 아니라서 intent로 전달 불가
            Log.d(TAG, "onPostAddressSuccess 이름이랑 주소id: ${result.name}  ${result.idx}")  //works
            super.finish()
        } else if(response.code==3021){
            showCustomToast("기본 배송지 등록이 필요합니다")
        }

    }

    override fun onPostAddressFailure(message: String) {
        Log.d(TAG, "onPostAddressFailure: $message")
    }

    private fun activateSaveBtn(phoneNoChecked: Boolean, restChecked : Boolean) {
        if (phoneNoChecked && restChecked){
            Log.d(TAG, "onCreate: 저장 버튼 활성화")
            binding.saveAddressBtn.setBackgroundResource(R.drawable.login_button_clicked)
            binding.saveAddressBtn.isClickable = true
            binding.saveAddressBtn.isEnabled = true
        } else {
            Log.d(TAG, "onCreate: 저장 버튼 비활-")
            binding.saveAddressBtn.setBackgroundResource(R.drawable.login_button)
            binding.saveAddressBtn.isClickable = false
            binding.saveAddressBtn.isEnabled = false

        }

    }
}