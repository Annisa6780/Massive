package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class LaporanPolsekActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var database: DatabaseReference

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

        // Inisialisasi Firebase Database
        database = FirebaseDatabase.getInstance().reference.child("laporan")

        listView.setOnItemClickListener { parent, view, position, id ->
            val polsek = polsek[position]

            // Simpan data laporan ke Firebase Database
            val laporanKey = database.push().key
            if (laporanKey != null) {
                database.child(laporanKey).setValue(selectedPolsek)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Data berhasil disimpan
                            val intent = Intent(this, FormPelaporanActivity::class.java)
                            intent.putExtra("laporanKey", laporanKey)
                            startActivity(intent)
                        } else {
                            // Penanganan kesalahan saat menyimpan data
                        }
                    }
            }
        }
    }
}






