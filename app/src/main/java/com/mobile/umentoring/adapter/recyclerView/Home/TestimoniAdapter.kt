package com.mobile.umentoring.adapter.recyclerView.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataItemTestimoni

class TestimoniAdapter(val dataTest: List<DataItemTestimoni?>?) :
    RecyclerView.Adapter<TestimoniAdapter.TestimoniHolder>() {
    class TestimoniHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.ivTestImg)
        val batch = itemView.findViewById<TextView>(R.id.tvTestBatch)
        val nama = itemView.findViewById<TextView>(R.id.tvTestName)
        val desk = itemView.findViewById<TextView>(R.id.tvTestDesk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimoniHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_testimoni, parent, false)
        val holder = TestimoniHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: TestimoniHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataTest?.get(position)?.user?.image)
            .into(holder.img)

        holder.batch.text = dataTest?.get(position)?.user?.level
        holder.nama.text = dataTest?.get(position)?.user?.name
        holder.desk.text = dataTest?.get(position)?.deskripsi
    }

    override fun getItemCount(): Int {
        return dataTest?.size ?: 0
    }

}