package com.example.kream.kotlin.src.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop.ShopProductAdapter

data class JdData (var productImg:Int, var brandLogo:Int, var productName:String, var price:Int)

class HomeJustDroppedAdapter (private val jdList: List<JdData>): RecyclerView.Adapter<HomeJustDroppedAdapter.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val productImg = itemView.findViewById<ImageView>(R.id.product_img)
        val brandLogo = itemView.findViewById<ImageView>(R.id.brand_logo)
        val productName = itemView.findViewById<TextView>(R.id.product_name)
        val price = itemView.findViewById<TextView>(R.id.buy_now_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_just_dropped_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productImg.setImageResource(R.drawable.jordan_test)
        holder.brandLogo.setImageResource(R.drawable.logo_jordan)
        holder.productName.text = jdList[position].productName
        holder.price.text = jdList[position].price.toString()
    }

    override fun getItemCount(): Int = jdList.size

}