package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    var btnSementara: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        btnSementara = findViewById(R.id.btnMasuk)

        btnSementara?.setOnClickListener {
            startActivity(Intent(this@LoginActivity, PelaporActivity::class.java))
        }
    }
}