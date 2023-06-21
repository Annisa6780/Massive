package com.example.massivechallage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AdapterLaporanDiproses(private val LapDiprosesList: ArrayList<DataLaporanDiproses>) : RecyclerView.Adapter<AdapterLaporanDiproses.LapDiprosesViewHolder>()  {


    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listenerlapDiproses: onItemClickListener){
        mListener = listenerlapDiproses
    }


    class LapDiprosesViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder (itemView){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LapDiprosesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_laporan_diproses, parent, false)
        return LapDiprosesViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: LapDiprosesViewHolder, position: Int) {
        val currentItem = LapDiprosesList[position]
        holder.tvJudulLaporan.text = currentItem.judul_laporan
        holder.tvjenisLaporan.text = currentItem.jenis_laporan
        holder.tvtanggalLaporan.text = currentItem.tanggal_laporan
        holder.tvstatusLaporan.text = currentItem.status_laporan
        holder.ivFoto.setImageResource(currentItem.foto_pelapor)
    }

    override fun getItemCount(): Int {
        return LapDiprosesList.size
    }
}