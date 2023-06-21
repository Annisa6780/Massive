package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        var btnPP: LinearLayout? = null
        btnPP = findViewById(R.id.profil)
        val onClickListener = btnPP?.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}