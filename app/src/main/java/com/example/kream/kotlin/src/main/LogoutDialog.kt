package com.example.kream.kotlin.src.main

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.config.BaseFragment
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity
import com.example.kream.kotlin.util.LoadingDialog

class LogoutDialog(context:Context) {
    private val logoutDialog = Dialog(context)
    val context = context
    lateinit var mLoadingDialog: LoadingDialog

    val jwt = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)
    val TAG = "log"

    fun showLogoutDialog(){
        logoutDialog.setContentView(R.layout.my_logout_dialog)
//        logoutDialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        logoutDialog.setCanceledOnTouchOutside(true)
        logoutDialog.setCancelable(true)
        logoutDialog.show()

        val noBtn =  logoutDialog.findViewById<TextView>(R.id.logout_no)
        val yesBtn =  logoutDialog.findViewById<TextView>(R.id.logout_yes)

        yesBtn.setOnClickListener {
            mLoadingDialog = LoadingDialog(context)    //로딩 다이얼로그 띄우기
            mLoadingDialog.show()

            ApplicationClass.editor.remove(ApplicationClass.X_ACCESS_TOKEN)
            ApplicationClass.editor.commit()

            Log.d("log", "마이페이지 - 로그아웃 완료!!! jwt =  $jwt")
            logoutDialog.dismiss()

            //메인액티비티로 화면 이동
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)

            if (mLoadingDialog.isShowing) {  //로딩다이얼로그 dismiss
                mLoadingDialog.dismiss()
            }

        }

        noBtn.setOnClickListener {
            logoutDialog.dismiss()
        }

    }




}