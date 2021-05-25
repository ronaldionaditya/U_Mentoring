package com.mobile.umentoring.adapter.recyclerView.Profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataTestimoniProfile

class TestimoniProfileAdapter(var data: List<DataTestimoniProfile?>?) :
    RecyclerView.Adapter<TestimoniProfileAdapter.TestimoniProfileHolder>() {
    class TestimoniProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageTest = itemView.findViewById<ImageView>(R.id.profile_testimoni)
        var batchTest = itemView.findViewById<TextView>(R.id.tvBatchTest)
        var nameTest = itemView.findViewById<TextView>(R.id.tvNameTest)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimoniProfileHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_testimoni, parent, false)
        val holder = TestimoniProfileHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: TestimoniProfileHolder, position: Int) {
//        Glide.with(holder.itemView.context)
//            .load(data?.get(position)?.gambardimodel)
//            .into(holder.imageTest)
        holder.batchTest.text = data?.get(position)?.deskripsi
        holder.nameTest.text = data?.get(position)?.id.toString()
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}