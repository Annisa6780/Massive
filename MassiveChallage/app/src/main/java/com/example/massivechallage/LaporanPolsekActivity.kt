package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class LaporanPolsekActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_laporan_polsek)

        listView = findViewById(R.id.lv_pelaporan)
        val polsek = arrayOf(
            "Polsek Lubuk Baja", "polsek Batam Kota", "Polsek Sekupang",
            "Polsek Nongsa", "Polsek Batu Aji", "Polsek Batu Ampar",
            "Polsek Belakang Padang", "Polsek KKP", "Polsek Bengkong",
            "Polsek Sei Beduk", "Polsek Sagulung", "Polsek Galang",
            "Polsek KKB", "Polsek Barelang"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, polsek)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val polsek = polsek[position]

            val i = Intent(this, FormPelaporanActivity::class.java)
            i.putExtra("polsek", polsek)
            startActivity(i)
           /* val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "$selectedItem", Toast.LENGTH_SHORT).show()
        */}

    }
}