package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)

            // Dapatkan teks dari RadioButton yang dipilih
            val selectedText = radioButton.text.toString()

            // Lakukan sesuatu dengan teks yang dipilih
            Toast.makeText(this, "Anda memilih: $selectedText", Toast.LENGTH_SHORT).show()
        }

    }
}