package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LaporDanRiwayatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_lapor_dan_riwayat)

        var tv3: TextView? = null
        tv3 = findViewById(R.id.textView3)
        tv3?.setOnClickListener {
            startActivity(Intent(this, LaporanPolsekActivity::class.java))
        }

        var tv4: TextView? = null
        tv4 = findViewById(R.id.textView4)
        tv4?.setOnClickListener {
            startActivity(Intent(this, RiwayatLaporanActivity::class.java))
        }
    }
}