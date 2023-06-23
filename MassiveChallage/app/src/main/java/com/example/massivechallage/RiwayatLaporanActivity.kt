package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RiwayatLaporanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_riwayat_laporan)

        var btnPengajuan: CardView? = null
        btnPengajuan = findViewById(R.id.cv_pengajuanLaporan)
        btnPengajuan?.setOnClickListener {
            startActivity(Intent(this, LaporDanRiwayatActivity::class.java))
        }

        var btnProses: CardView? = null
        btnProses = findViewById(R.id.cv_laporanDiproses)
        btnProses?.setOnClickListener {
            startActivity(Intent(this, LaporanDiprosesActivity::class.java))
        }

        var btnTerima: CardView? = null
        btnTerima = findViewById(R.id.cv_laporanDiterima)
        btnTerima?.setOnClickListener {
            startActivity(Intent(this, LaporanDiterimaActivity::class.java))
        }

        var btnTolak: CardView? = null
        btnTolak = findViewById(R.id.cv_laporanDitolak)
        btnTolak?.setOnClickListener {
            startActivity(Intent(this, LaporanDitolakActivity::class.java))
        }

//        val RiwayatLaporanList = listOf<DataRiwayatLaporan>(
//            DataRiwayatLaporan(
//                jenisLaporan = "Pelecehan Seksual",
//                tanggalLapor = "4 Juni 2023",
//                alamatPelapor = "Jl A",
//                statusLaporan = R.string.status_menunggu,
//                statuswarLaporan = R.color.status_menunggu
//            ),
//            DataRiwayatLaporan(
//                jenisLaporan = "Cyberbullying",
//                tanggalLapor = "6 Juni 2023",
//                alamatPelapor = "Jl b",
//                statusLaporan = R.string.status_proses,
//                statuswarLaporan = R.color.status_proses
//            ),
//            DataRiwayatLaporan(
//                jenisLaporan = "Eksploitasi",
//                tanggalLapor = "7 Juni 2023",
//                alamatPelapor = "Jl c",
//                statusLaporan = R.string.status_diterima,
//                statuswarLaporan = R.color.status_terima
//            ),
//            DataRiwayatLaporan(
//                jenisLaporan = "Eksploitasi",
//                tanggalLapor = "7 Juni 2023",
//                alamatPelapor = "Jl c",
//                statusLaporan = R.string.status_diterima,
//                statuswarLaporan = R.color.status_terima
//            )
//        )
//
//        val recyclerView = findViewById<RecyclerView>(R.id.rv_riwayatlaporan)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = AdapterRiwayatLaporan(this, RiwayatLaporanList){
//
//        }
    }
}