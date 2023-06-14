package com.example.massivechallage

import android.app.Activity
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

        //setting tombol unggah bukti
        val uploadButton = findViewById<Button>(R.id.btn_unggahBukti)

        uploadButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image"  // Tipe berkas foto

            //startActivityForResult(intent, REQUEST_CODE)
        }


        //setting button
        val btnsimpan = findViewById<Button>(R.id.btn_simpan)
        btnsimpan.setOnClickListener {
            // Kode untuk menampilkan Toast dan membaca data dari database
            Toast.makeText(this, "Data telah terkirim", Toast.LENGTH_SHORT).show()

        }
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            val selectedFileUri = data?.data
            // Lakukan tindakan sesuai dengan berkas gambar yang telah dipilih

            // Contoh: Simpan URI berkas ke dalam database
            if (selectedFileUri != null) {
                val filePath = selectedFileUri.toString()
                // Simpan filePath ke dalam database
            }
        }
    }*/

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Tangani pilihan yang dipilih
        val selectedItem = parent?.getItemAtPosition(position).toString()
        // Lakukan operasi yang diperlukan dengan item yang dipilih


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}