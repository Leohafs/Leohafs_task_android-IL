package com.example.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalList : ArrayList<Animal>) : RecyclerView.Adapter<AnimalAdapter.holderView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderView {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_animal,
            parent,false)
        return holderView(itemView)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: holderView, position: Int) {
        val curretnItem = animalList[position]
        holder.tvimage.setImageResource(curretnItem.image)
        holder.tvheading.text = curretnItem.heading
        holder.tvdeskripsi.text = curretnItem.deskripsi
    }

    class holderView(itemView : View) : RecyclerView.ViewHolder(itemView){

        val tvimage : ImageView = itemView.findViewById(R.id.img_animal)
        val tvheading : TextView = itemView.findViewById(R.id.tv_heading)
        val tvdeskripsi : TextView = itemView.findViewById(R.id.tv_deskripsi)
    }
}