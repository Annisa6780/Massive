package com.example.massivechallage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class KontakPolisiActivity : AppCompatActivity() {

//    private lateinit var dbref: DatabaseReference
    private lateinit var kprecyclerView: RecyclerView
    private lateinit var KontakList: ArrayList<DataKontakPolisi>
    lateinit var datanama : Array<String>
    lateinit var dataalamat : Array<String>
    lateinit var datatelp : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kontak_polisi)

        datanama = arrayOf(
            "Polsek Lubuk Baja",
            "polsek Batam Kota",
            "Polsek Sekupang",
            "Polsek Nongsa",
            "Polsek Batu Aji",
            "Polsek Batu Ampar",
            "Polsek Belakang Padang",
            "Polsek KKP",
            "Polsek Bengkong",
            "Polsek Sei Beduk",
            "Polsek Sagulung",
            "Polsek Galang",
            "Polsek KKB Hang Nadim"

        )

        dataalamat = arrayOf(
            "Jl. Bunga Raya, Baloi Indah, Batam Kota, Kota Batam, Kepulauan Riau ",
            "Jl. Engku Putri, Baloi Permai, Batam Kota, Kota Batam, Kepulauan Riau",
            "Jl. Ir. Sutami, Sungai Harapan, Kota Batam, Kepulauan Riau",
            "Jl. Hasanuddin, Batu Besar, Batam Kota, Kota Batam, Kepulauan Riau",
            "Jl. Brigjen Katamso, Tj. Uncang, Batu Aji, Kota Batam, Kepulauan Riau",
            "Jalan Yos Sudarso Kota Batam, Kepulauan Riau",
            "Jl. Hang Tuah, Belakang Padang, Kota Batam, Kepulauan Riau",
            "Jl. RE Martadinata, Sekupang, Kota Batam, Kepulauan Riau",
            "Bengkong Laut, Bengkong, Kota Batam, Kepulauan Riau",
            "Jl. Kapling Sei Pancur Kota Batam, Kepulauan Riau",
            "Jl. Ir. Suprapto Sagulung, Kota Batam, Kepulauan Riau",
            "Sembulang, Galang, Kota Batam, Kepulauan Ria",
            "Bandara Hang Nadim, Kota Batam, Kepuluan Riau",

        )

        datatelp = arrayOf(
            "(0778) 457212",
            "(0778) 463360",
            "(0778) 321744",
            "(0778) 311110",
            "(0778) 393162",
            "(0778) 432573",
            "(0778) 312254",
            "(0778) 327652",
            "(0778) 413110",
            "(0778) 736234",
            "(0778) 393435",
            "-",
            "(0778) 479276"
        )

        kprecyclerView = findViewById(R.id.rvkontakpolisi)
        kprecyclerView.layoutManager = LinearLayoutManager(this)
        kprecyclerView.setHasFixedSize(true)

        KontakList = arrayListOf<DataKontakPolisi>()
        getUserData()

//        kprecyclerView = findViewById(R.id.listkontakpolisi)
//        kprecyclerView.layoutManager = LinearLayoutManager(this)
//        kprecyclerView.setHasFixedSize(true)
//
//
//        getKpData()
    }



    /*private fun getKpData() {
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

            }

        })*/

//        val databaseRef = FirebaseDatabase.getInstance().reference.child("nama_tabel")
//        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                for (snapshot in dataSnapshot.children) {
//                    // Ambil nilai dari setiap child dalam dataSnapshot
//                    val value = snapshot.getValue(KontakPolisi::class.java)
//
//                    // Lakukan sesuatu dengan nilai yang diperoleh
//                    if (value != null) {
//                        // Misalnya, tampilkan nilai dalam log
//                        Log.d("Data", "Nilai: ${value.field1}, ${value.field2}")
//
//                        // Atau tambahkan nilai ke dalam list
//                        listkontakpolisi.add(value)
//                    }
//                }
//            }

//            override fun onCancelled(databaseError: DatabaseError) {
//                // Tangani jika terjadi kesalahan
//                Log.e("Error", "Gagal mengambil data: ${databaseError.message}")
//            }
//        })

//    }

    private fun getUserData() {

        for (i in datanama.indices){
            val itemPel = DataKontakPolisi(
                datanama[i],
                dataalamat[i],
                datatelp[i]
            )
            KontakList.add(itemPel)
        }

        val kontakListAdapter = cardViewKontakPolisi(KontakList)
        kprecyclerView.adapter = kontakListAdapter
        kontakListAdapter.setOnItemClickListener(object : cardViewKontakPolisi.onItemClickListener{
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@PelaporActivity, "Kamu menklik item ke-$position", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this@KontakPolisiActivity, DetailPelaporActivity::class.java)
//                intent.putExtra("dataJudulLaporan",KontakList[position].nama)
//                intent.putExtra("dataJenisKekerasan",KontakList[position].alamat)
//                intent.putExtra("dataFotoPelapor",KontakList[position].telp)
//
//
//                startActivity(intent)
            }

        })
    }


    /*  private fun getDataFromDatabase(): List<KontakPolisi> {
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