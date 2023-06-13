package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class DetailPelaporActivity : AppCompatActivity() {
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

        val bundle : Bundle?= intent.extras
        val judul = bundle!!.getString("dataJudulLaporan")
        val jenis = bundle.getString("dataJenisKekerasan")
        val foto = bundle.getInt("dataFotoPelapor")
        val nama = bundle.getString("namaPelapor")
        val nik = bundle.getString("nikPelapor")
        val ttl = bundle.getString("ttlPelapor")
        val telp = bundle.getString("telpPelapor")
        val alamat = bundle.getString("alamatPelapor")
        val lokasi = bundle.getString("lokasiKejadian")
        val tgl = bundle.getString("tglKejadian")
        val deskripsi = bundle.getString("deskripsi")
        val bukti = bundle.getInt("buktifoto")

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
}