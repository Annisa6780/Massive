package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class AkunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        var btnEditPP: CardView? = null
        btnEditPP = findViewById(R.id.editprofil)
        btnEditPP?.setOnClickListener {
            startActivity(Intent(this, EditProfilActivity::class.java))
        }

        var btnPengaturan: CardView? = null
        btnPengaturan = findViewById(R.id.pengaturan)
        btnPengaturan?.setOnClickListener {
            startActivity(Intent(this, PengaturanActivity::class.java))
        }

        var btnLogout: LinearLayout? = null
        btnLogout = findViewById(R.id.keluar)
        btnLogout?.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}