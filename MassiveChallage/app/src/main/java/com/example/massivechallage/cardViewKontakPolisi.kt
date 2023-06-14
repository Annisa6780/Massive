package com.example.massivechallage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class cardViewKontakPolisi (private val dataSet: List<String>) :
RecyclerView.Adapter<cardViewKontakPolisi.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardTextView: TextView = view.findViewById(R.id.cv_kontak)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kontak_polisi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.cardTextView.text = item
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
