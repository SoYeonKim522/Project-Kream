package com.example.kream.kotlin.src.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.home.models.MainBannerResult

class ViewPagerAdapter(private val imageList:List<MainBannerResult>, val context: Context?)
    :RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.home_viewpager, parent, false)){
        val image = itemView.findViewById<ImageView>(R.id.home_iv_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder((parent))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUrl:String = imageList[position].image
        if (imgUrl.isNotEmpty()){
            Glide.with(holder.itemView).load(imgUrl).error(R.drawable.login_button).into(holder.image)
        }
    }

    override fun getItemCount(): Int = imageList.size



}