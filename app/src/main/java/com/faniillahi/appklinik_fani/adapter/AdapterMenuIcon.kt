package com.faniillahi.appklinik_fani.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faniillahi.appklinik_fani.R
import com.faniillahi.appklinik_fani.model.ModelIcon

class AdapterMenuIcon(
    val itemMenuList: List<ModelIcon>
) : RecyclerView.Adapter<AdapterMenuIcon.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenuIcon: ImageView = itemView.findViewById(R.id.imgMenuIcon)
        val txtNamaMenu: TextView = itemView.findViewById(R.id.txtNamaMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemMenuList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemMenuList[position]
        holder.imgMenuIcon.setImageResource(currentItem.iconImage)
        holder.txtNamaMenu.setText(currentItem.iconName)
    }
}