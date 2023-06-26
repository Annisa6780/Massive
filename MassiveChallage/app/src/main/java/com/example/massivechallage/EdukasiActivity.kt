package com.example.massivechallage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class EdukasiActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edukasi)

        var card1: CardView? = null
        card1 = findViewById(R.id.card1)
       card1?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasiActivity::class.java))
        }

        var card2: CardView? = null
        card2 = findViewById(R.id.card2)
        card2?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasiActivity::class.java))
        }

        var card3: CardView? = null
        card3 = findViewById(R.id.card3)
        card3?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasiActivity::class.java))
        }

        var art1: CardView? = null
        art1 = findViewById(R.id.art1)
        art1?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi2Activity::class.java))
        }

        var art2: CardView? = null
        art2 = findViewById(R.id.art2)
        art2?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi3Activity::class.java))
        }

        var art3: CardView? = null
        art3 = findViewById(R.id.art3)
        art3?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi4Activity::class.java))
        }

        var art4: CardView? = null
        art4 = findViewById(R.id.art4)
        art4?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi5Activity::class.java))
        }

        var art5: CardView? = null
        art5 = findViewById(R.id.art5)
        art5?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi2Activity::class.java))
        }

        var art6: CardView? = null
        art6 = findViewById(R.id.art6)
        art6?.setOnClickListener{
            startActivity(Intent(this, DetailEdukasi3Activity::class.java))
        }
    }
}