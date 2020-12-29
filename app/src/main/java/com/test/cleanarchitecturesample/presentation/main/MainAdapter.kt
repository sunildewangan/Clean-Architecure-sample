package com.test.cleanarchitecturesample.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.cleanarchitecturesample.R
import com.test.cleanarchitecturesample.domain.HerosModel

class MainAdapter(
    private val heros: List<HerosModel> = ArrayList<HerosModel>()
): RecyclerView.Adapter<MainAdapter.MyViewHolder>() {


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.name)
        val image:ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        holder.titleTextView.text = heros.get(position).name
        //holder.itemView.setOnClickListener { itemClickListener.invoke(heros[position]) }
    }

    override fun getItemCount(): Int {
       return heros.size
    }
}