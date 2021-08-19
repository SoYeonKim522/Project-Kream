package com.example.kream.kotlin.src.main.shop_product

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop_product.models.ProductImageResult

//data class ImgData(var image:Int)

class ProductImageViewpagerAdapter(private val imgList: List<ProductImageResult>, val context: Context?)
    : RecyclerView.Adapter<ProductImageViewpagerAdapter.ViewHolder>() {

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.shop_product_viewpager, parent, false)) {
        val image = itemView.findViewById<ImageView>(R.id.product_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder((parent))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.image.setImageResource(imgList[position])
        val imgUrl:String = imgList[position].imageUrl
        if (imgUrl.isNotEmpty()){
            Glide.with(holder.itemView).load(imgUrl).error(R.drawable.login_button).into(holder.image)
        }
    }

    override fun getItemCount(): Int = imgList.size


}