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
import com.example.kream.kotlin.src.main.shop.models.CategoryResponse
import com.example.kream.kotlin.src.main.shop.models.DetailCategory

//data class ShopCategoryData(var image:String, var catName:String) {
//}
//ㄴ원래 이게 클래스 선언할때 들어갔음
    //CategoryResponse 가 아니라 원하는 데이터가 들어있는 리스트로 넣어줘야함!!

class ShopCategoryAdapter(private val catList:List<DetailCategory>, val context: Context?)
    :RecyclerView.Adapter<ShopCategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.shop_cat_img)
        val name = itemView.findViewById<TextView>(R.id.shop_cat_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_recycler_cat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //val imgUrl:String = catList!![position].result.categoryList[0].detailCategoryList[0].imageUrl
        val imgUrl:String = catList[position].imageUrl


        if(imgUrl.isNotEmpty()){
            Glide.with(holder.itemView).load(imgUrl).error(R.drawable.login_button).into(holder.image)
        }
        //holder.name.text = catList[position].result.categoryList[0].detailCategoryList[0].name
        holder.name.text = catList[position].name


//        val data = catList[position]
//
//        val imgUrl:String = data.image
//        if(imgUrl.isNotEmpty()){
//            Glide.with(holder.itemView).load(imgUrl).error(R.drawable.login_button).into(holder.image)
//        }

//        holder.image.setImageResource(catList.get(position).image)

//        holder.name.text = data.catName
    }

    override fun getItemCount(): Int = catList.size
//    {
//        var size: Int = 0
//        if(catList != null){
//            size = catList.size
//        }
//        return size
//    }

}