package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class LaporandanRiwayatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporandan_riwayat)

        var btnLaporan: CardView? = null
        btnLaporan = findViewById(R.id.laporan_polsek)
        btnLaporan?.setOnClickListener {
            startActivity(Intent(this, LaporanPolsekActivity::class.java))
        }

        var btnRiwayat: CardView? = null
        btnRiwayat = findViewById(R.id.riwayat_laporan)
        btnRiwayat?.setOnClickListener {
            startActivity(Intent(this, RiwayatLaporanActivity::class.java))
        }
    }
}