package com.example.kream.kotlin.src.main.shop_product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop_product.models.RecList

class RecommendAdapter (private var recList:List<RecList>, val context: Context?): RecyclerView.Adapter<RecommendAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val productImg = itemView.findViewById<ImageView>(R.id.product_img)
        val brandLogo = itemView.findViewById<ImageView>(R.id.brand_logo)
        val productName = itemView.findViewById<TextView>(R.id.product_name)
        val price = itemView.findViewById<TextView>(R.id.buy_now_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_rec_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUrl :String = recList[position].thumbnail
        val brandLogoUrl : String = recList[position].brandLogo

        if (imgUrl!=null){
            Glide.with(holder.itemView).load(imgUrl).error(R.drawable.login_button).into(holder.productImg)
        }
        if (brandLogoUrl!=null){
            Glide.with(holder.itemView).load(brandLogoUrl).error(R.drawable.login_button).into(holder.brandLogo)
        }

        holder.productName.text = recList[position].name
        val priceData = recList[position].buyPrice
        if(priceData == 0){
            holder.price.text = "-"
        } else holder.price.text = priceData.toString()

    }

    override fun getItemCount(): Int  = recList.size
}