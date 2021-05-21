package com.mobile.umentoring.adapter.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataItemProgramProfile
import com.mobile.umentoring.model.ResponseProgramProfile

class ProgramProfileAdapter(val data: DataItemProgramProfile?) :
    RecyclerView.Adapter<ProgramProfileAdapter.ProgramProfileHolder>() {
    class ProgramProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageProgram = itemView.findViewById<ImageView>(R.id.ivImageProgram)
        var namaProgram = itemView.findViewById<TextView>(R.id.tvNamaProgram)
        var angkatanProgram = itemView.findViewById<TextView>(R.id.tvAngkatan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramProfileHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_class, parent, false)
        val holder = ProgramProfileHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProgramProfileHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data?.program?.programImage)
            .into(holder.imageProgram)
        holder.namaProgram.text = data?.program?.namaProgram
        holder.angkatanProgram.text = data?.angkatan
    }

    override fun getItemCount(): Int {
        //TODO SALAH DISINI DATA TIDAK ARRAY
        return  0
    }
}