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
import com.example.kream.kotlin.src.main.shop_product_by_size.models.SellPriceResult

class SellPriceAdapter(private var sizeList:List<SellPriceResult>, val context: Context?): RecyclerView.Adapter<SellPriceAdapter.ViewHolder>() {

    private val TAG = "log"

    //인터페이스 만들기
    interface OnSizeClickListenerS{
        fun onSizeClickS(view:View)
    }
    private var listener : OnSizeClickListenerS?=null
    fun setOnSizeClickListenerS(listener : OnSizeClickListenerS){
        this.listener = listener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val size = itemView.findViewById<TextView>(R.id.size)
        val price = itemView.findViewById<TextView>(R.id.size_price)
        val container = itemView.findViewById<ImageView>(R.id.size_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_size_sell_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.price.setTextColor(R.color.prod_sell_price_by_size.toInt())
        val sizetxt = sizeList[position].productSize
        if (sizetxt == "모든 사이즈") {
            holder.size.text = "모든 사이즈"
            holder.size.setTextSize(13F)
        } else holder.size.text = sizetxt

        val priceBySize = sizeList[position].salePrice
        if (priceBySize == 0 || priceBySize==null) {
            holder.price.text = "판매 입찰"
            holder.price.setTextColor(R.color.black.toInt())
            holder.price.setTypeface(null, Typeface.BOLD)
            holder.price.setTextSize(12F)
        } else holder.price.text = priceBySize.toString() + "원"


        //각 사이즈 별 클릭 리스너
        holder.itemView.setOnClickListener {
            //데이터 전달
            val intent = Intent(holder.itemView.context, ShopProductActivity::class.java)
            intent.putExtra("size", sizetxt)
            intent.putExtra("sellPrice", priceBySize.toString() + "원")
            Log.d(TAG, "onBindViewHolder: $sizetxt, $priceBySize")

            listener?.onSizeClickS(holder.itemView)
        }

    }

    override fun getItemCount(): Int = sizeList.size
}