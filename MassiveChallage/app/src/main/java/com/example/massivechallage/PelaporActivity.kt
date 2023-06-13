package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PelaporActivity : AppCompatActivity() {

    private lateinit var  rv_listpelapor : RecyclerView
    private lateinit var listPelapor : ArrayList<DataPelapor>
    lateinit var dataJudul : Array<String>
    lateinit var dataJenis : Array<String>
    lateinit var dataTanggal : Array<String>
    lateinit var dataStatus : String
    lateinit var dataFoto : Array<Int>

    lateinit var nama : Array<String>
    lateinit var nik : Array<String>
    lateinit var ttl : Array<String>
    lateinit var telp : Array<String>
    lateinit var alamat : Array<String>
    lateinit var lokasi : Array<String>
    lateinit var tglKejadian : Array<String>
    lateinit var desc : Array<String>
    lateinit var bukti : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pelapor)

        dataJudul = arrayOf(
            "Pembulian di Institut Teknologi Batam",
            "Pembulian di SMA",
            "Pelecehan di Universitas",
            "Pembulian di Sekolah"
        )

        dataJenis = arrayOf(
            "Bullying",
            "Cyberbullying",
            "Fisik atau Psikis",
            "Pelecehan Seksual"
        )

        dataTanggal = arrayOf(
            "1/6/2023",
            "2/6/2023",
            "3/6/2023",
            "4/6/2023"
        )

        dataStatus = "Laporan Diproses"

        dataFoto = arrayOf(
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto3,
            R.drawable.foto4
        )

        nama = arrayOf(
            "Erika",
            "Putri",
            "Sakira",
            "Renata"
        )

        nik = arrayOf(
            "01234567230158901",
            "12438759827348827",
            "38349182732710394",
            "13247218734827390"
        )

        ttl = arrayOf(
            "Batam, 23 Januari 1985",
            "Batam, 23 Juni 2004",
            "Batam, 23 Oktober 2000",
            "Batam, 23 November 2009"
        )

        telp = arrayOf(
            "086767657123",
            "085123123123",
            "081123456667",
            "085878678456"
        )

        alamat = arrayOf(
            "Tiban Mas, blok AAA 100, RT 02, RW 05, Tiban Lama, Sekupang, Batam",
            "Tiban Mas, blok AAA 100, RT 02, RW 05, Tiban Lama, Sekupang, Batam",
            "Tiban Mas, blok AAA 100, RT 02, RW 05, Tiban Lama, Sekupang, Batam",
            "Tiban Mas, blok AAA 100, RT 02, RW 05, Tiban Lama, Sekupang, Batam"
        )

        lokasi = arrayOf(
            "Institut Teknologi Batam",
            "SMA Negeri Batam",
            "Universitas Negeri Batam",
            "SMP Negeri Batam"
        )

        tglKejadian = arrayOf(
            "Senin, 22 April 2023",
            "Senin, 3 Maret 2023",
            "Senin, 16 Januari 2023",
            "Senin, 10 April 2023"
        )

        desc = arrayOf(
            getString(R.string.desc_a),
            getString(R.string.desc_b),
            getString(R.string.desc_c),
            getString(R.string.desc_d)
        )

        bukti = arrayOf(
            R.drawable.bukti1,
            R.drawable.bukti2,
            R.drawable.bukti3,
            R.drawable.bukti1
        )



        rv_listpelapor = findViewById(R.id.rv_pelapor)
        rv_listpelapor.layoutManager = LinearLayoutManager(this)
        rv_listpelapor.setHasFixedSize(true)

        listPelapor = arrayListOf<DataPelapor>()
        getUserData()

    }

    private fun getUserData() {

        for (i in dataJudul.indices){
            val itemPel = DataPelapor(
                dataJudul[i],
                dataJenis[i],
                dataTanggal[i],
                dataStatus,
                dataFoto[i]
            )
            listPelapor.add(itemPel)
        }

        val pelaporListAdapter = AdapterPelapor(listPelapor)
        rv_listpelapor.adapter = pelaporListAdapter
        pelaporListAdapter.setOnItemClickListener(object : AdapterPelapor.onItemClickListener{
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@PelaporActivity, "Kamu menklik item ke-$position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@PelaporActivity, DetailPelaporActivity::class.java)
                intent.putExtra("dataJudulLaporan",listPelapor[position].judul_laporan)
                intent.putExtra("dataJenisKekerasan",listPelapor[position].jenis_laporan)
                intent.putExtra("dataFotoPelapor",listPelapor[position].foto_pelapor)

                intent.putExtra("namaPelapor", nama[position])
                intent.putExtra("nikPelapor", nik[position])
                intent.putExtra("ttlPelapor", ttl[position])
                intent.putExtra("telpPelapor", telp[position])
                intent.putExtra("alamatPelapor", alamat[position])
                intent.putExtra("lokasiKejadian", lokasi[position])
                intent.putExtra("tglKejadian", tglKejadian[position])
                intent.putExtra("deskripsi", desc[position])
                //kurang gambar bukti
                intent.putExtra("buktifoto", bukti[position])

                startActivity(intent)
            }

        })
    }


}