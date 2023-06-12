package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PelaporActivity : AppCompatActivity() {

    private lateinit var  rv_listpelapor : RecyclerView
    private var list = ArrayList<DataPelapor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pelapor)

        rv_listpelapor = findViewById(R.id.rv_pelapor)
        rv_listpelapor.setHasFixedSize(true)

        list.addAll(listPelapor)
        showRecyclerView()
    }

    private val listPelapor : ArrayList<DataPelapor>
    get() {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataJenis = resources.getStringArray(R.array.data_jenis)
        val dataTanggal = resources.getStringArray(R.array.data_tanggal)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val dataFoto = resources.obtainTypedArray(R.array.data_photo)

        val dataList = ArrayList<DataPelapor>()

        for(i in dataJudul.indices){
            val itemPel = DataPelapor(
                dataJudul[i],
                dataJenis[i],
                dataTanggal[i],
                dataStatus[i],
                dataFoto.getResourceId(i, -1)
            )

            dataList.add(itemPel)
        }
        return dataList
    }
    fun showRecyclerView(){
        rv_listpelapor.layoutManager = LinearLayoutManager(this)
        val pelaporListAdapter = AdapterPelapor(list)
        rv_listpelapor.adapter = pelaporListAdapter
    }
}