package com.example.massivechallage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.massivechallage.R
import com.google.firebase.database.FirebaseDatabase


class FormPelaporanActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var namaPelaporEditText: EditText
    private lateinit var usiaEditText: EditText
    private lateinit var noTelpEditText: EditText
    private lateinit var alamatEditText: EditText
    private lateinit var lokasiEditText: EditText
    private lateinit var tglKejadianEditText: EditText
    private lateinit var judulLaporanEditText: EditText
    private lateinit var jenisLaporanSpinner: Spinner
    private lateinit var isiLaporanEditText: EditText
    private lateinit var unggahBuktiButton: Button
    private lateinit var simpanButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_form_pelaporan)

        namaPelaporEditText = findViewById(R.id.edt_nama_pelapor)
        usiaEditText = findViewById(R.id.adt_usia)
        noTelpEditText = findViewById(R.id.edt_noTelp)
        alamatEditText = findViewById(R.id.edt_alamat)
        lokasiEditText = findViewById(R.id.edt_lokasi)
        tglKejadianEditText = findViewById(R.id.edt_tglKejadian)
        judulLaporanEditText = findViewById(R.id.edt_judul)
        jenisLaporanSpinner = findViewById(R.id.jenis_laporan)
        isiLaporanEditText = findViewById(R.id.edt_isiLaporan)
        unggahBuktiButton = findViewById(R.id.btn_unggahBukti)
        simpanButton = findViewById(R.id.btn_simpan)

        simpanButton.setOnClickListener {
            saveDataToFirebase()
        }

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


    private fun saveDataToFirebase() {
        val database = FirebaseDatabase.getInstance()
        val ref = database.reference.child("pelaporan")

        val namaPelapor = namaPelaporEditText.text.toString()
        val usia = usiaEditText.text.toString().toInt()
        val noTelp = noTelpEditText.text.toString()
        val alamat = alamatEditText.text.toString()
        val lokasiKejadian = lokasiEditText.text.toString()
        val tglKejadian = tglKejadianEditText.text.toString()
        val judulLaporan = judulLaporanEditText.text.toString()
        val jenisLaporan = jenisLaporanSpinner.selectedItem.toString()
        val isiLaporan = isiLaporanEditText.text.toString()

        val laporanData = HashMap<String, Any>()
        laporanData["namaPelapor"] = namaPelapor
        laporanData["usia"] = usia
        laporanData["noTelp"] = noTelp
        laporanData["alamat"] = alamat
        laporanData["lokasiKejadian"] = lokasiKejadian
        laporanData["tglKejadian"] = tglKejadian
        laporanData["judulLaporan"] = judulLaporan
        laporanData["jenisLaporan"] = jenisLaporan
        laporanData["isiLaporan"] = isiLaporan

        val laporanKey = ref.push().key
        if (laporanKey != null) {
            ref.child(laporanKey).setValue(laporanData)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Data saved successfully
                    } else {
                        // Failed to save data
                    }
                }
        }
    }
}