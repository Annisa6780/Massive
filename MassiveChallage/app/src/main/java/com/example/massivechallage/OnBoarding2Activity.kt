package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button

class OnBoarding2Activity : AppCompatActivity() {

    var btnOB2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //untuk menghilangkan appsbar
        setContentView(R.layout.activity_on_boarding2)

        btnOB2 = findViewById(R.id.btnOB2)

        btnOB2?.setOnClickListener {
            startActivity(Intent(this@OnBoarding2Activity, OnBoarding3Activity::class.java))
        }
    }
}