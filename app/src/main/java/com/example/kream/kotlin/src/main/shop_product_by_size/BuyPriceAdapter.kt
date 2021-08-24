package com.example.kream.kotlin.src.main.shop_product_by_size

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
import com.example.kream.kotlin.src.main.shop_product_by_size.models.BuyPriceResult
import kotlin.properties.Delegates

class BuyPriceAdapter(private var sizeList:List<BuyPriceResult>, val context: Context?): RecyclerView.Adapter<BuyPriceAdapter.ViewHolder>() {

//    private lateinit var listener: SizeClickListener
    private val TAG = "log"
    private var clickedSize=-1


    //인터페이스 만들기
    interface OnSizeClickListener{
        fun onSizeClick(view:View, size:String, price:Int)
    }
    private var listener : OnSizeClickListener?=null
    fun setOnSizeClickListener(listener : OnSizeClickListener){
        this.listener = listener
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val size = itemView.findViewById<TextView>(R.id.size)
        val price = itemView.findViewById<TextView>(R.id.size_price)
        val container = itemView.findViewById<ImageView>(R.id.size_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_size_recycler_item, parent, false)
        Log.d(TAG, "onCreateViewHolder: 초기 $clickedSize")
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sizetxt = sizeList[position].productSize
        if(sizetxt=="모든 사이즈"){
            holder.size.text = "모든 사이즈"
            holder.size.setTextSize(13F)
        } else holder.size.text = sizetxt

        val priceBySize = sizeList[position].buyPrice
        if(priceBySize==0 || priceBySize==null){
            holder.price.text = "구매 입찰"
            holder.price.setTextColor(R.color.black.toInt())
            holder.price.setTypeface(null, Typeface.BOLD)
            holder.price.setTextSize(12F)
        } else holder.price.text = priceBySize.toString() + "원"

        //이전에 선택된 것이 있다면
        if(position==clickedSize){
            Log.d(TAG, "onBindViewHolder: 선택되어있는 $position")
            //뷰 스타일 변경
            holder.size.setTypeface(null, Typeface.BOLD)
            holder.price.setTypeface(null, Typeface.BOLD)
            holder.container.setImageResource(R.drawable.prod_size_button_clicked)
        } else {
            holder.size.setTypeface(null, Typeface.NORMAL)
            holder.price.setTypeface(null, Typeface.NORMAL)

        }


        //각 사이즈 별 클릭 리스너
        holder.itemView.setOnClickListener {
            clickedSize=position
            Log.d(TAG, "onBindViewHolder: 선택지금함 $clickedSize")
            //데이터 전달
            val intent = Intent(holder.itemView.context, ShopProductActivity::class.java)
            intent.putExtra("size", sizetxt)
            intent.putExtra("buyPrice", priceBySize.toString()+"원")
            //인터페이스
            listener?.onSizeClick(holder.itemView, sizetxt, priceBySize)
        }
    }

    override fun getItemCount(): Int  = sizeList.size



}