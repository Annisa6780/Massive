package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import de.hdodenhof.circleimageview.CircleImageView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        var btnPP: CircleImageView? = null
        btnPP = findViewById(R.id.profil)
        @Suppress("UNUSED_VARIABLE") val onClickListener = btnPP?.setOnClickListener {
            startActivity(Intent(this, AkunActivity::class.java))
        }

        var btnArtikel: FrameLayout? = null
        btnArtikel = findViewById(R.id.artikel)
        btnArtikel?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasiActivity::class.java))
        }

        var btnArtikel1: FrameLayout? = null
        btnArtikel1 = findViewById(R.id.artikel1)
        btnArtikel1?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasiActivity::class.java))
        }

        var btnArtikel2: FrameLayout? = null
        btnArtikel2 = findViewById(R.id.artikel2)
        val onClickListener1 = btnArtikel2?.setOnClickListener {
            startActivity(Intent(this, DetailEdukasiActivity::class.java))
        }

        var btnEdu: LinearLayout? = null
        btnEdu = findViewById(R.id.edu)
        btnEdu?.setOnClickListener{
            startActivity(Intent(this, EdukasiActivity::class.java))
        }

        var btnLaporan: LinearLayout? = null
        btnLaporan = findViewById(R.id.laporan)
        btnLaporan?.setOnClickListener{
            startActivity(Intent(this, LaporandanRiwayatActivity::class.java))
        }

        var btnKontak: LinearLayout? = null
        btnKontak = findViewById(R.id.kontak)
        btnKontak?.setOnClickListener{
            startActivity(Intent(this, KontakPolisiActivity::class.java))
        }

        var ar: CardView? = null
        ar = findViewById(R.id.ar)
       ar?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi2Activity::class.java))
        }

        var ar1:CardView? = null
        ar1 = findViewById(R.id.ar1)
       ar1?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi3Activity::class.java))
        }
    }
}