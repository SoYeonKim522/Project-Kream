package com.example.kream.kotlin.src.main.style

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.style.models.StyleList

class StyleAdapter(private val styleList:List<StyleList>, val context: Context?):RecyclerView.Adapter<StyleAdapter.ViewHolder>() {

    private val TAG ="log"

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val profilePic = itemView.findViewById<ImageView>(R.id.profile_pic)
        val userId = itemView.findViewById<TextView>(R.id.user_id)
        val content = itemView.findViewById<TextView>(R.id.content)
        val likedCnt = itemView.findViewById<TextView>(R.id.liked_cnt)
        val commentCnt = itemView.findViewById<TextView>(R.id.comment_cnt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.style_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl:String = styleList[position].images[0].image
        if(imageUrl.isNotEmpty()){
            Glide.with(holder.itemView).load(imageUrl).error(R.drawable.login_button).into(holder.image)
        }
        val profileImgUrl= styleList[position].userProfileImage
        if(profileImgUrl!=null && profileImgUrl.isNotEmpty()){
            Glide.with(holder.itemView).load(profileImgUrl).error(R.drawable.login_button).into(holder.profilePic)
        } else holder.profilePic.setImageResource(R.drawable.my_default_profile_pic)
        holder.userId.text = styleList[position].userNickName
        holder.content.text = styleList[position].content
        holder.likedCnt.text = styleList[position].liked.toString()
        holder.commentCnt.text = styleList[position].commented.toString()
    }

    override fun getItemCount(): Int = styleList.size

}