package com.example.kream.kotlin.src.main.shop_product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop_product.models.SalesTransaction


class SalesTableAdapter(private var salesList:List<SalesTransaction>, val context: Context?): RecyclerView.Adapter<SalesTableAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val size = itemView.findViewById<TextView>(R.id.sales_first_column)
        val salesPrice = itemView.findViewById<TextView>(R.id.sales_second_column)
        val date = itemView.findViewById<TextView>(R.id.sales_third_column)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_sales_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.size.text = salesList[position].productSize
        holder.salesPrice.text = salesList[position].transactedPrice.toString()+"원"
        holder.date.text = salesList[position].transactedAt
    }

    override fun getItemCount(): Int {
        return if(salesList.size>5){
            5
        } else salesList.size
    }
}

