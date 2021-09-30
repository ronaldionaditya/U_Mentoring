package com.mobile.umentoring.adapter.recyclerView.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataItemLeaderboad

class LeaderboardAdapter(val data: List<DataItemLeaderboad?>?) :
    RecyclerView.Adapter<LeaderboardAdapter.LeaderboardHolder>() {
    class LeaderboardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageLB = itemView.findViewById<ImageView>(R.id.imgLeaderboard)
        var nomorLB = itemView.findViewById<TextView>(R.id.tvNomorLeaderboard)
        var namaLB = itemView.findViewById<TextView>(R.id.tvNameLeaderboard)
        var sekolahLB = itemView.findViewById<TextView>(R.id.tvSekolahLeaderboard)
        var classLB = itemView.findViewById<TextView>(R.id.tvClassLeaderboard)
        var scoreLB = itemView.findViewById<TextView>(R.id.tvScoreLeaderboard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leaderboard_list, parent, false)
        val holder = LeaderboardAdapter.LeaderboardHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: LeaderboardHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.participant?.image)
            .into(holder.imageLB)

        holder.nomorLB.text = data?.get(position)?.participant?.id.toString()
        holder.namaLB.text = data?.get(position)?.participant?.name
        holder.sekolahLB.text = data?.get(position)?.participant?.sekolah
        holder.classLB.text = data?.get(position)?.participant?.angkatan
        holder.scoreLB.text = data?.get(position)?.total.toString()

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}