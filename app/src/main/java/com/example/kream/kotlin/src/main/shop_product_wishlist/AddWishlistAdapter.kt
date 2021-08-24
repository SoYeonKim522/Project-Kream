package com.example.kream.kotlin.src.main.shop_product_wishlist

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeList

class AddWishlistAdapter(private var sizeList:List<SizeList>, val context: Context?): RecyclerView.Adapter<AddWishlistAdapter.ViewHolder>() {

    val TAG = "log"
    var addedToWishlist:Boolean = false

    //인터페이스 만들기 - 관심상품 추가
    interface OnWishClickListener{
        fun onWishClick(view:View, productSizeIdx:Int)
    }
    private var listener : OnWishClickListener?=null
    fun setOnWishClickListener(listener : OnWishClickListener){
        this.listener = listener
    }

    //인터페이스 만들기 - 관심상품 삭제
    interface OnWishClickListenerD{
        fun onWishClickD(view:View, productSizeIdx:Int)
    }
    private var listenerD : OnWishClickListenerD?=null
    fun setOnWishClickListenerD(listener : OnWishClickListenerD){
        this.listenerD = listener
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val size = itemView.findViewById<TextView>(R.id.size)
        val icon = itemView.findViewById<ImageView>(R.id.recycler_wishlish_icon)
        val container = itemView.findViewById<ImageView>(R.id.wishlist_size_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_add_wishlist_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sizeIdx = sizeList[position].productSizeIdx
        holder.size.text = sizeList[position].size

        val clickedItem=ArrayList<Int>()
        //클릭 시 토글 효과 & 관심상품 추가 api
        holder.itemView.setOnClickListener {
            if(clickedItem.contains(position)){
                //관심 상품 제거
                holder.size.setTypeface(null, Typeface.NORMAL)
                holder.icon.setImageResource(R.drawable.wishlist_icon_black)
                holder.container.setImageResource(R.drawable.prod_size_button)
                clickedItem.remove(position)
                //인터페이스
                listenerD?.onWishClickD(holder.itemView, sizeIdx)
            } else {
                //관심 상품 추가
                holder.size.setTypeface(null, Typeface.BOLD)
                holder.icon.setImageResource(R.drawable.wishlist_icon_clicked)
                holder.container.setImageResource(R.drawable.prod_size_button_clicked)
                clickedItem.add(position)
                //인터페이스
                listener?.onWishClick(holder.itemView, sizeIdx)
            }
        }

        //인터페이스 (리사이클러뷰 아이템 클릭할때마다 관심 상품 api 호출)
        val intent = Intent(holder.itemView.context, ProdWishlistFragment::class.java)
        val wishAddedSize = sizeList[position].productSizeIdx
        intent.putExtra("wishAddedSize", wishAddedSize) //사이즈 전달





//        어댑터.notifyDataSetChanged()

//        val intent = Intent(holder.itemView.context, ShopProductActivity::class.java)
//        if(clickedItem.size>0){
//            addedToWishlist = true
//            intent.putExtra("isWishlistAdded", addedToWishlist)
//            holder.itemView.context.startActivity(intent)
//            Log.d(TAG, "onBindViewHolder 인텐트: $intent")
//        } else {
//            addedToWishlist = false
//            intent.putExtra("isWishlistAdded", addedToWishlist)
//            holder.itemView.context.startActivity(intent)
//        }


    }

    override fun getItemCount(): Int = sizeList.size
}