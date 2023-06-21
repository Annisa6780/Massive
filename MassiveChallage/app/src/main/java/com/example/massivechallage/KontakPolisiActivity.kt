package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.massivechallage.data.adapter.AdapterKontakPolisi
import com.example.massivechallage.data.KontakPolisi
import com.google.firebase.database.*

class KontakPolisiActivity : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var kprecyclerView: RecyclerView
    private lateinit var kpArrayList: ArrayList<KontakPolisi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kontak_polisi)

        kprecyclerView = findViewById(R.id.listkontakpolisi)
        kprecyclerView.layoutManager = LinearLayoutManager(this)
        kprecyclerView.setHasFixedSize(true)


        getKpData()

    }

    private fun getKpData() {
        dbref = FirebaseDatabase.getInstance().getReference("polsek")
        kpArrayList = arrayListOf<KontakPolisi>()
        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (kpSnapshot in snapshot.children) {

                        val kp = kpSnapshot.getValue(KontakPolisi::class.java)
                        kp?.let {
                            kpArrayList.add(it)
                        }

                    }

                    Toast.makeText(this@KontakPolisiActivity,"Test Data $kpArrayList", Toast.LENGTH_SHORT).show()
                    kprecyclerView.adapter = AdapterKontakPolisi(kpArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
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