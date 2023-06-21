package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_dashboar)

        var btnBeranda: Button? = null
        btnBeranda = findViewById(R.id.llBeranda)
        btnBeranda?.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        var btnEdu: Button? = null
        btnEdu = findViewById(R.id.llEdu)
            btnEdu?.setOnClickListener {
                startActivity(Intent(this, EdukasiActivity::class.java))
        }

        var btnPelaporan: Button? = null
        btnPelaporan = findViewById(R.id.llLapor)
        btnPelaporan?.setOnClickListener {
            startActivity(Intent(this, LaporDanRiwayatActivity::class.java))
        }


        var btnKontak: Button? = null
        btnKontak = findViewById(R.id.llBeranda)
        btnKontak?.setOnClickListener {
            startActivity(Intent(this, KontakPolisiActivity::class.java))
        }
    }
}