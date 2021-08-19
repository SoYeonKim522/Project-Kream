package com.example.kream.kotlin.src.main.shop_product

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kream.kotlin.R


class ShopProdInfoAdapter (private val ProdDataList:MutableList<String>, val context: Context?):RecyclerView.Adapter<ShopProdInfoAdapter.ViewHolder>() {
    val TAG  = "log"
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.prod_description_title)
        val content = itemView.findViewById<TextView>(R.id.prod_description_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prod_info_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.title.text = ProdDataList[position].title
        //holder.content.text = ProdDataList[position].content

        when(position){
            0 -> { holder.title.text = "모델번호"
                holder.content.setTypeface(null, Typeface.BOLD) //모델번호 텍스트만 bold 처리
                holder.content.text = ProdDataList[0]
            }
            1 -> { holder.title.text = "출시일"
                holder.content.text = ProdDataList[1]
            }
            2 -> { holder.title.text = "대표색상"
                holder.content.text = ProdDataList[2]
            }
            3 -> { holder.title.text = "발매가"
                holder.content.text = ProdDataList[3]
            }
        }
    }

    override fun getItemCount(): Int  = ProdDataList.size

}