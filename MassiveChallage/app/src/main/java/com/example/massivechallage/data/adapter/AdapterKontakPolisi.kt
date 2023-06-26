package com.example.massivechallage.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.massivechallage.DataKontakPolisi
import com.example.massivechallage.R

//link tutorial https://www.youtube.com/watch?v=VVXKVFyYQdQ

class AdapterKontakPolisi(private val listkontakpolisi: List<DataKontakPolisi>) : RecyclerView.Adapter<AdapterKontakPolisi.MyViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_kontak_polisi, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return listkontakpolisi.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listkontakpolisi[position]

        holder.nama_polsek.text = currentItem.nama
        holder.alamat_polsek.text = currentItem.alamat
        holder.telp_polsek.text = currentItem.telp
    }

    class  MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        //val pp_polsek : ImageView = itemView.findViewById(R.id.pp_polsek)
        val nama_polsek : TextView = itemView.findViewById(R.id.nama_polsek)
        val alamat_polsek : TextView = itemView.findViewById(R.id.alamat_polsek)
        val telp_polsek : TextView = itemView.findViewById(R.id.telp_polsek)

    }

}
