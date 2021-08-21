package com.example.kream.kotlin.src.main.shop

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop.models.ProductResult
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity


class ShopProductAdapter (private val productList:List<ProductResult>, val context: Context?)
    : RecyclerView.Adapter<ShopProductAdapter.ViewHolder>(){

    private val TAG ="log"

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
        val priceData = productList[position].buyPrice
        if(priceData==null || priceData==0){
            holder.price.text = "-"
        } else holder.price.text = priceData.toString()

        holder.productName.text = productList[position].description
        holder.wishlistCnt.text = productList[position].liked.toString()
        holder.postingCnt.text = productList[position].tagged.toString()

        //상품클릭 -> 상품상세페이지 이동 w/ 상품인덱스
        val productIdx = productList[position].idx
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ShopProductActivity::class.java)
            intent.putExtra("productIdx", productIdx)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = productList.size
}