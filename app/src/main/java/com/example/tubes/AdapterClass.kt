package com.example.tubes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<dataClassRv>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    var onItemClick: ((dataClassRv) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_desain_resep, parent, false)
        return ViewHolderClass(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle
        holder.rvKalori.text = currentItem.dataKalori

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage:ImageView = itemView.findViewById(R.id.imageMenu)
        val rvTitle:TextView = itemView.findViewById(R.id.title)
        val rvKalori:TextView = itemView.findViewById(R.id.kalori)

    }
}