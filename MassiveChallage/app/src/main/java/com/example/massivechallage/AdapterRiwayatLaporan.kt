package com.example.massivechallage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRiwayatLaporan(private val context: Context, private val RiwayatLaporan: List<DataRiwayatLaporan>, val listener: (DataRiwayatLaporan) ->Unit)
    : RecyclerView.Adapter<AdapterRiwayatLaporan.RiwayatLaporanViewHolder>(){

    class RiwayatLaporanViewHolder(view: View): RecyclerView.ViewHolder(view) {

//        val jenisLaporan = view.findViewById<TextView>(R.id.tv_jenislaporan)
//        val tanggalLapor = view.findViewById<TextView>(R.id.tv_tanggal_lapor)
//        val alamatPelapor = view.findViewById<TextView>(R.id.tv_alamat_riwayat)
//        val statusLaporan = view.findViewById<TextView>(R.id.tv_status_riwayat)
//        val statuswarLaporan = view.findViewById<TextView>(R.id.tv_status_riwayat)

        fun bindView(RiwayatLaporan: DataRiwayatLaporan, listener: (DataRiwayatLaporan) -> Unit) {
//            jenisLaporan.text = DataRiwayatLaporan.jenisLaporan
//            tanggalLapor.text = DataRiwayatLaporan.tanggalLapor
//            alamatPelapor.text = DataRiwayatLaporan.alamatPelapor
//            statusLaporan.text= DataRiwayatLaporan.statusLaporan
//            statuswarLaporan.textColors
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatLaporanViewHolder {
        return RiwayatLaporanViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_riwayatlaporan, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RiwayatLaporanViewHolder, position: Int) {
        holder.bindView(RiwayatLaporan[position], listener)
    }

    override fun getItemCount(): Int = RiwayatLaporan.size

    }

