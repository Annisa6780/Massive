package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RiwayatLaporanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_laporan)

        val RiwayatLaporanList = listOf<DataRiwayatLaporan>(
            DataRiwayatLaporan(
                jenisLaporan = "Pelecehan Seksual",
                tanggalLapor = "4 Juni 2023",
                alamatPelapor = "Jl A",
                statusLaporan = R.string.status_menunggu,
                statuswarLaporan = R.color.status_menunggu
            ),
            DataRiwayatLaporan(
                jenisLaporan = "Cyberbullying",
                tanggalLapor = "6 Juni 2023",
                alamatPelapor = "Jl b",
                statusLaporan = R.string.status_proses,
                statuswarLaporan = R.color.status_proses
            ),
            DataRiwayatLaporan(
                jenisLaporan = "Eksploitasi",
                tanggalLapor = "7 Juni 2023",
                alamatPelapor = "Jl c",
                statusLaporan = R.string.status_diterima,
                statuswarLaporan = R.color.status_terima
            ),
            DataRiwayatLaporan(
                jenisLaporan = "Eksploitasi",
                tanggalLapor = "7 Juni 2023",
                alamatPelapor = "Jl c",
                statusLaporan = R.string.status_diterima,
                statuswarLaporan = R.color.status_terima
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_riwayatlaporan)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = AdapterRiwayatLaporan(this, RiwayatLaporanList){

        }
    }
}