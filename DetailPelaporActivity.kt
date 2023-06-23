package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import com.google.firebase.database

class DetailPelaporActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pelapor)

        val namaPelapor : TextView = findViewById(R.id.tv_namapelapor)
        val nikPelapor : TextView = findViewById(R.id.tv_nikpelapor)
        val ttlPelapor : TextView = findViewById(R.id.tc_ttlpelapor)
        val telpPelapor : TextView = findViewById(R.id.tv_telppelapor)
        val alamatPelapor : TextView = findViewById(R.id.tv_alamatpelapor)
        val lokasiPelapor : TextView = findViewById(R.id.tv_lokasi)
        val tglKejadian : TextView = findViewById(R.id.tv_tanggalkejadian)
        val desc : TextView = findViewById(R.id.tv_deskripsi)
        val buktiFoto : ImageView = findViewById(R.id.iv_buktigambar)
        val judulKekerasan : TextView = findViewById(R.id.tv_judulkekerasan)
        val jenisKekerasan : TextView = findViewById(R.id.tv_jeniskekerasan)
        val fotoPelapor : CircleImageView = findViewById(R.id.civ_fotoprofil)

        // Get the unique identifier of the data you want to retrieve
        val dataId = intent.getStringExtra("dataId")

        // Get a reference to the Firebase Realtime Database
        database = FirebaseDatabase.getInstance().reference.child("your_data_node").child(dataId)

        // Attach a ValueEventListener to retrieve data from Firebase
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val judul = snapshot.child("dataJudulLaporan").getValue(String::class.java)
                val jenis = snapshot.child("dataJenisKekerasan").getValue(String::class.java)
                val foto = snapshot.child("dataFotoPelapor").getValue(Int::class.java)
                val nama = snapshot.child("namaPelapor").getValue(String::class.java)
                val nik = snapshot.child("nikPelapor").getValue(String::class.java)
                val ttl = snapshot.child("ttlPelapor").getValue(String::class.java)
                val telp = snapshot.child("telpPelapor").getValue(String::class.java)
                val alamat = snapshot.child("alamatPelapor").getValue(String::class.java)
                val lokasi = snapshot.child("lokasiKejadian").getValue(String::class.java)
                val tgl = snapshot.child("tglKejadian").getValue(String::class.java)
                val deskripsi = snapshot.child("deskripsi").getValue(String::class.java)
                val bukti = snapshot.child("buktifoto").getValue(Int::class.java)

        judulKekerasan.text = judul
        jenisKekerasan.text = jenis
        fotoPelapor.setImageResource(foto)
        namaPelapor.text = nama
        nikPelapor.text =  nik
        ttlPelapor.text =  ttl
        telpPelapor.text = telp
        alamatPelapor.text = alamat
        lokasiPelapor.text =lokasi
        tglKejadian.text = tgl
        desc.text = deskripsi
        buktiFoto.setImageResource(bukti)
    }
            override fun onCancelled(error: DatabaseError) {
                // Handle the error appropriately
            }
        })
}