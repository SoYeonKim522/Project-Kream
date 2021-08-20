package com.example.kream.kotlin.src.main.shop_product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop_product.models.BidsList

class BidsTableAdapter(private var bidsList: List<BidsList>, val context:Context?) : RecyclerView.Adapter<BidsTableAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val size = itemView.findViewById<TextView>(R.id.sales_first_column)
        val bidPrice = itemView.findViewById<TextView>(R.id.sales_second_column)
        val quantity = itemView.findViewById<TextView>(R.id.sales_third_column)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_sales_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.size.text = bidsList[position].productSize
        holder.bidPrice.text = bidsList[position].bidPrice.toString()+"원"
        holder.quantity.text = bidsList[position].count.toString()
    }

    override fun getItemCount(): Int = 5
}