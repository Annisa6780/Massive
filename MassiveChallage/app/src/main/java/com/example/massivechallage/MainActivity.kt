package com.example.massivechallage

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val link: TextView = findViewById(R.id.tes)
        link.paintFlags=link.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        link.setOnClickListener {
            val url= "https://www.journaldev.com"
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }


    }
}