package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoarding4Activity : AppCompatActivity() {

    var btnOB4: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding4)

        btnOB4 = findViewById(R.id.btnOB4)

        btnOB4?.setOnClickListener {
            startActivity(Intent(this@OnBoarding4Activity, LoginActivity::class.java))
        }
    }
}