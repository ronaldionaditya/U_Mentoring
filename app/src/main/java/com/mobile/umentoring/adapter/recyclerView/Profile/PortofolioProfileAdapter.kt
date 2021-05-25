package com.mobile.umentoring.adapter.recyclerView.Profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataItemPortofolioProfile

class PortofolioProfileAdapter(val data: List<DataItemPortofolioProfile?>?) :
    RecyclerView.Adapter<PortofolioProfileAdapter.PortofolioProfileHolder>() {
    class PortofolioProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagePort = itemView.findViewById<ImageView>(R.id.ivPortfolioPort)
        var batchPort = itemView.findViewById<TextView>(R.id.tvAngkatanPort)
        var levelPort = itemView.findViewById<TextView>(R.id.tvLevelPort)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortofolioProfileHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_portofolio, parent, false)
        val holder = PortofolioProfileHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: PortofolioProfileHolder, position: Int) {
//        Glide.with(holder.itemView.context)
//            .load(data?.get(position)?.gambardimodel)
//            .into(holder.imagePort)
        holder.batchPort.text = data?.get(position)?.participantsId.toString()
        holder.levelPort.text = data?.get(position)?.link
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

}