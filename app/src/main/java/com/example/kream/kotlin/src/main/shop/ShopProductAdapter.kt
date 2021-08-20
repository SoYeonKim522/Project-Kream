package com.example.kream.kotlin.src.main.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop.models.ProductResult


class ShopProductAdapter (private val productList:List<ProductResult>, val context: Context?)
    : RecyclerView.Adapter<ShopProductAdapter.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val productImg = itemView.findViewById<ImageView>(R.id.product_img)
        val brandLogo = itemView.findViewById<ImageView>(R.id.brand_logo)
        val productName = itemView.findViewById<TextView>(R.id.product_name)
        val price = itemView.findViewById<TextView>(R.id.buy_now_price)
        val wishlistCnt = itemView.findViewById<TextView>(R.id.wishlish_count)
        val postingCnt = itemView.findViewById<TextView>(R.id.posting_count)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUrl :String = productList[position].thumbnail
        if (imgUrl.isNotEmpty()){
            Glide.with(holder.itemView).load(imgUrl).error(R.drawable.login_button).into(holder.productImg)
        }

        val brandLogoUrl : String = productList[position].brandLogo
        if(brandLogoUrl!=null){
            Glide.with(holder.itemView).load(brandLogoUrl).error(R.drawable.login_button).into(holder.brandLogo)
        } else {
            holder.brandLogo.setImageResource(R.drawable.login_button)
        }

        holder.productName.text = productList[position].description
        holder.price.text = productList[position].buyPrice.toString()
        holder.wishlistCnt.text = productList[position].liked.toString()
        holder.postingCnt.text = productList[position].tagged.toString()
    }

    override fun getItemCount(): Int = productList.size
}