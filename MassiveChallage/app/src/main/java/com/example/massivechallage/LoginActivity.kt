package com.example.massivechallage

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    var btnLogin: Button? = null
    var btnDaftar: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnMasuk)
        btnLogin?.setOnClickListener {
            startActivity(Intent(this@LoginActivity, PelaporActivity::class.java))
        }

        btnDaftar = findViewById(R.id.daftar)
        btnDaftar?.setOnClickListener {
            startActivity(Intent(this@LoginActivity, DaftarActivity::class.java))
        }

    }
}