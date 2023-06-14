package com.example.massivechallage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KontakPolisiActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
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

}