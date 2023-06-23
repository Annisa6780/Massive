package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
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

    }
}