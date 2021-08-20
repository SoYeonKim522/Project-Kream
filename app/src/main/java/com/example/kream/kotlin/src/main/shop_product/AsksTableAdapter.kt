package com.example.kream.kotlin.src.main.shop_product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R
import com.example.kream.kotlin.src.main.shop_product.models.AsksList

class AsksTableAdapter(private var asksList:List<AsksList>, val context: Context?): RecyclerView.Adapter<AsksTableAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val size = itemView.findViewById<TextView>(R.id.sales_first_column)
        val askedPrice = itemView.findViewById<TextView>(R.id.sales_second_column)
        val quantity = itemView.findViewById<TextView>(R.id.sales_third_column)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_sales_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.size.text = asksList[position].productSize
        holder.askedPrice.text = asksList[position].bidPrice.toString()+"원"
        holder.quantity.text = asksList[position].count.toString()
    }

    override fun getItemCount(): Int {
        return if(asksList.size>5){
            5
        } else asksList.size
    }
}