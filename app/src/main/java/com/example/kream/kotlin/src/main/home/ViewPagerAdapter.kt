package com.example.kream.kotlin.src.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R

class ViewPagerAdapter(imageList:ArrayList<Int>) :RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    var imageList = imageList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder((parent))

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewHolder, position: Int) {
        holder.image.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.home_viewpager, parent, false)){
        val image = itemView.findViewById<ImageView>(R.id.home_iv_image)

    }

}