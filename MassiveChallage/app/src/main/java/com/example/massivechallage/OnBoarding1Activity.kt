package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoarding1Activity : AppCompatActivity() {

    var btnOB1: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() //untuk menghilangkan appsbar
        setContentView(R.layout.activity_on_boarding1)

        btnOB1 = findViewById(R.id.btnOB1)

        btnOB1?.setOnClickListener {
            startActivity(Intent(this@OnBoarding1Activity, OnBoarding2Activity::class.java))
        }
    }
}