package com.example.massivechallage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database

class KontakPolisiActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: cardViewKontakPolisi
    private lateinit var database: DatabaseReference
    private lateinit var adapter: cardViewKontakPolisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kontak_polisi)

        recyclerView = findViewById(R.id.rv_kontakpolisi)

        // Inisialisasi data dari database
        //val dataList = getDataFromDatabase()

        // Buat instance adapter dan teruskan data dari database
        //adapter = cardViewKontakPolisi(dataList)

        // Atur layout manajer dan adapter untuk RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance().reference

        recyclerView = findViewById(R.id.rv_kontakpolisi)

        // Atur layout manajer untuk RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from Firebase Realtime Database
        fetchDataFromDatabase()
    }

        /*private fun getDataFromDatabase(): List<DataModel> {
            // Kode untuk mengambil data dari database sesuai preferensi Anda
            // Kemudian, konversikan data menjadi objek DataModel dan kembalikan sebagai daftar
        }*/

    /*override fun onBindViewHolder(holder: cardViewKontakPolisi.ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.cardTextView.text = item.name

        holder.itemView.setOnClickListener {
            val phoneNumber = item.phoneNumber // Ambil nomor telepon dari objek data di database
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            holder.itemView.context.startActivity(intent)
        }*/
    private fun fetchDataFromDatabase() {
        val kontakPolisiRef = database.child("kontak_polisi")

        kontakPolisiRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dataList = mutableListOf<DataModel>()

                for (snapshot in dataSnapshot.children) {
                    val dataModel = snapshot.getValue(DataModel::class.java)
                    dataModel?.let { dataList.add(it) }
                }

                // Buat instance adapter dan teruskan data dari database
                adapter = cardViewKontakPolisi(dataList)

                // Atur adapter untuk RecyclerView
                recyclerView.adapter = adapter
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error if needed
            }
        })
    }
}