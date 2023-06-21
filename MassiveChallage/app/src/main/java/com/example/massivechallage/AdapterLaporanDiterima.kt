package com.example.massivechallage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.hdodenhof.circleimageview.CircleImageView

class AdapterLaporanDiterima(private val LapDiterimaList: ArrayList<DataLaporanDiterima>) : RecyclerView.Adapter<AdapterLaporanDiterima.LapDiterimaViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listenerlapDiterima: onItemClickListener){
        mListener = listenerlapDiterima
    }


    class LapDiterimaViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val tvJudulLaporan : TextView = itemView.findViewById(R.id.tv_judulLaporan)
        val tvjenisLaporan : TextView = itemView.findViewById(R.id.tv_jenisLaporan)
        val tvtanggalLaporan : TextView = itemView.findViewById(R.id.tv_tanggalLaporan)
        val tvstatusLaporan: TextView = itemView.findViewById(R.id.tv_statusLaporan)
        val ivFoto: CircleImageView = itemView.findViewById(R.id.iv_foto)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LapDiterimaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_laporan_diterima, parent, false)
        return LapDiterimaViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: LapDiterimaViewHolder, position: Int) {
        val currentItem = LapDiterimaList[position]
        holder.tvJudulLaporan.text = currentItem.judul_laporan
        holder.tvjenisLaporan.text = currentItem.jenis_laporan
        holder.tvtanggalLaporan.text = currentItem.tanggal_laporan
        holder.tvstatusLaporan.text = currentItem.status_laporan
        holder.ivFoto.setImageResource(currentItem.foto_pelapor)
    }

    override fun getItemCount(): Int {
        return LapDiterimaList.size
    }

}