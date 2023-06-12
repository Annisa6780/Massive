package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.massivechallage.R

class FormPelaporanActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_form_pelaporan)
//setting dropdown
        val spinner = findViewById<Spinner>(R.id.jenis_laporan)

        val adapter = ArrayAdapter.createFromResource(this, R.array.list_kekerasan, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = this

        //setting button
        val btnsimpan = findViewById<Button>(R.id.btn_simpan)
        btnsimpan.setOnClickListener {
            // Kode untuk menampilkan Toast dan membaca data dari database
            Toast.makeText(this, "Data telah terkirim", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Tangani pilihan yang dipilih
        val selectedItem = parent?.getItemAtPosition(position).toString()
        // Lakukan operasi yang diperlukan dengan item yang dipilih


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}