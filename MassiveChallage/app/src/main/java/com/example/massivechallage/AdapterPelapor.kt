package com.example.massivechallage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AdapterPelapor(private val pelapor: ArrayList<DataPelapor>) : RecyclerView.Adapter<AdapterPelapor.PelaporViewHolder>() {

    class PelaporViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView){
        val tvJudulLaporan : TextView = itemView.findViewById(R.id.tv_judulLaporan)
        val tvjenisLaporan : TextView = itemView.findViewById(R.id.tv_jenisLaporan)
        val tvtanggalLaporan : TextView = itemView.findViewById(R.id.tv_tanggalLaporan)
        val tvstatusLaporan: TextView = itemView.findViewById(R.id.tv_statusLaporan)
        val ivFoto: CircleImageView = itemView.findViewById(R.id.iv_foto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PelaporViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelapor, parent, false)
        return PelaporViewHolder(view)
    }

    override fun onBindViewHolder(holder: PelaporViewHolder, position: Int) {
        val (judul_laporan, jenis_laporan, tanggal_laporan, status_laporan, foto_pelapor) = pelapor[position]
        holder.tvJudulLaporan.text = judul_laporan
        holder.tvjenisLaporan.text = jenis_laporan
        holder.tvtanggalLaporan.text = tanggal_laporan
        holder.tvstatusLaporan.text = status_laporan
        holder.ivFoto.setImageResource(foto_pelapor.toInt())

    }

    override fun getItemCount(): Int {
        return pelapor.size
    }
}