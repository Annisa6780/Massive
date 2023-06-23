package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailEdukasiActivity : AppCompatActivity() {

    // Deklarasikan variabel referensi database
    private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_edukasi)

        // Inisialisasi referensi database
        databaseRef = FirebaseDatabase.getInstance().reference

        // Contoh pengambilan data dari database
        val artikelRef = databaseRef.child("artikel")
        artikelRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Proses data yang diambil dari database
                for (artikelSnapshot in snapshot.children) {
                    val judulArtikel = artikelSnapshot.child("judul").value.toString()
                    val isiArtikel = artikelSnapshot.child("isi").value.toString()
                    // Lakukan sesuatu dengan data yang diambil
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Tangani kesalahan yang terjadi saat mengambil data
            }
        })
    }
}
