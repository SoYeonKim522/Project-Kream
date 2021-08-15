package com.example.kream.kotlin.src.main.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R

class ShopProductAdapter (private val productList:ArrayList<ShopProductData>): RecyclerView.Adapter<ShopProductAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val productImg = itemView.findViewById<ImageView>(R.id.product_img)
        val brandLogo = itemView.findViewById<ImageView>(R.id.brand_logo)
        val productName = itemView.findViewById<TextView>(R.id.product_name)
        val price = itemView.findViewById<TextView>(R.id.buy_now_price)
        val wishlistCnt = itemView.findViewById<TextView>(R.id.wishlish_count)
        val postingCnt = itemView.findViewById<TextView>(R.id.posting_count)
        //카테고리도 필요할 듯

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productImg.setImageResource(R.drawable.jordan_test)
        holder.brandLogo.setImageResource(R.drawable.logo_jordan)
        holder.productName.text = productList[position].productName
        holder.price.text = productList[position].price
        holder.wishlistCnt.text = productList[position].wishlistCount
        holder.postingCnt.text = productList[position].postingCount
    }

    override fun getItemCount(): Int = productList.size
}