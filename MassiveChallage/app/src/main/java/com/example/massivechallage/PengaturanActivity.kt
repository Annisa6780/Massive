package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class PengaturanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaturan)

        var btnTentang: CardView? = null
        btnTentang = findViewById(R.id.tentang)
        btnTentang?.setOnClickListener {
            startActivity(Intent(this, TentangActivity::class.java))
        }

        var btnKeamanan: CardView? = null
        btnKeamanan = findViewById(R.id.keamanan)
        btnKeamanan?.setOnClickListener {
            startActivity(Intent(this, KeamananActivity::class.java))
        }

        var btnBahasa: CardView? = null
        btnBahasa = findViewById(R.id.bahasa)
        btnBahasa?.setOnClickListener {
            startActivity(Intent(this, BahasaActivity::class.java))
        }

    }
}