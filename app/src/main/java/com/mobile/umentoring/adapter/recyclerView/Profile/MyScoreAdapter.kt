package com.mobile.umentoring.adapter.recyclerView.Profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataMyScore

class MyScoreAdapter(val data: List<DataMyScore?>?) :
    RecyclerView.Adapter<MyScoreAdapter.MyScoreHolder>() {
    class MyScoreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nomor = itemView.findViewById<TextView>(R.id.tvNomorMyScore)
        var kelas = itemView.findViewById<TextView>(R.id.tvClassScore)
        var angkatan = itemView.findViewById<TextView>(R.id.tvLevelScore)
        var total = itemView.findViewById<TextView>(R.id.tvTotalScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyScoreHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lastscore, parent, false)
        val holder = MyScoreAdapter.MyScoreHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: MyScoreHolder, position: Int) {
        holder.nomor.text = data?.get(position)?.programId.toString()
        holder.kelas.text = data?.get(position)?.participant?.name
        holder.angkatan.text = data?.get(position)?.participant?.angkatan
        holder.total.text = data?.get(position)?.totalScore.toString()
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

}