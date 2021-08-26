package com.example.kream.kotlin.src.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.home.models.ThemeProductList
import com.example.kream.kotlin.src.main.shop.ShopProductAdapter
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity

data class JdData (var productImg:Int, var brandLogo:Int, var productName:String, var price:Int)

class HomeJustDroppedAdapter (private val jdList: List<ThemeProductList>): RecyclerView.Adapter<HomeJustDroppedAdapter.ViewHolder>(){

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
        val imgUrl : String = jdList[position].productImage
        val brandLogoUrl : String = jdList[position].brandLogo
        if (imgUrl!=null){
            Glide.with(holder.itemView).load(imgUrl).error(R.drawable.login_button).into(holder.productImg)
        }
        if (brandLogoUrl!=null){
            Glide.with(holder.itemView).load(brandLogoUrl).error(R.drawable.login_button).into(holder.brandLogo)
        } else holder.brandLogo.setImageResource(R.drawable.logo_jordan)

        holder.productName.text = jdList[position].productName
        val price = jdList[position].buyPrice
        if(price==0){
            holder.price.text = "-"
        } else holder.price.text = jdList[position].buyPrice.toString()

        val productIdx = jdList[position].productIdx
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, ShopProductActivity::class.java)
            intent.putExtra("productIdx", productIdx)
            ContextCompat.startActivity(holder.itemView.context, intent, null)

        }

    }

    override fun getItemCount(): Int = jdList.size

}