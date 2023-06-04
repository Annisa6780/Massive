package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoarding3Activity : AppCompatActivity() {

    var btnOB3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding3)

        btnOB3 = findViewById(R.id.btnOB3)

        btnOB3?.setOnClickListener {
            startActivity(Intent(this@OnBoarding3Activity, OnBoarding4Activity::class.java))
        }
    }
}