package com.example.massivechallage

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.massivechallage.data.Pengguna
import com.example.massivechallage.databinding.ActivityDaftarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import android.Manifest
import android.widget.TextView


/*private var RadioGroup.error: String
    get() {}
    set() {}*/

class DaftarActivity : AppCompatActivity() {

    lateinit var  binding: ActivityDaftarBinding
    lateinit var auth : FirebaseAuth
    val CAMERA_PERMISSION_CODE = 100
    val CAMERA_REQUEST_CODE = 200

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityDaftarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnDaftar.setOnClickListener {
            val nama = binding.namaLengkap.text.toString()
            val nik = binding.editTextNumber.text.toString()
            val alamat = binding.alamatPelapor.text.toString()
            val ttl = binding.editTextDate.text.toString()
           /* val jenis_kelamin = binding.radioGroup.context.toString()*/ //perlu ditanyakan
            val telp = binding.editTextPhone.text.toString()
            val pekerjaan = binding.pekerjaan.text.toString()
            val pp = binding.btnUploadpp.toString()
            val email = binding.editTextTextEmailAddress.text.toString()
            val kata_sandi = binding.editTextTextPassword2.text.toString()
            val konfirm_pass = binding.editTextTextPassword3.text.toString()

            if (nama.isEmpty()) {
                binding.namaLengkap.error = "Nama Harus Terisi"
                binding.namaLengkap.requestFocus()
                return@setOnClickListener
            }

            if (nik.isEmpty()) {
                binding.editTextNumber.error = "Nomer Induk Kependudukan Harus Terisi"
                binding.editTextNumber.requestFocus()
                return@setOnClickListener
            }

            if (alamat.isEmpty()) {
                binding.alamatPelapor.error = "Alamat Harus Terisi"
                binding.alamatPelapor.requestFocus()
                return@setOnClickListener
            }

            if (ttl.isEmpty()) {
                binding.editTextDate.error = "Tanggal Lahir Harus Terisi"
                binding.editTextDate.requestFocus()
                return@setOnClickListener
            }

           /* if (jenis_kelamin.isEmpty()) {
                binding.radioGroup.error = "Wajib Pilih Salah Satu"
                binding.radioGroup.requestFocus()
                return@setOnClickListener
            }*/

            if (telp.isEmpty()) {
                binding.editTextPhone.error = "Nomor Telepon Harus Terisi"
                binding.editTextPhone.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.PHONE.matcher(telp).matches()){
                    binding.editTextPhone.error = "Nomor Telepon Tidak Valid"
                    binding.editTextPhone.requestFocus()
                    return@setOnClickListener
            }

            if (pekerjaan.isEmpty()) {
                binding.pekerjaan.error = "Pekerjaan Harus Terisi"
                binding.pekerjaan.requestFocus()
                return@setOnClickListener
            }

            if (pp.isEmpty()) {
                binding.btnUploadpp.error = "Ambil Gambar Foto Profile"
                binding.btnUploadpp.requestFocus()
                return@setOnClickListener
            }


            if (email.isEmpty()) {
                binding.editTextTextEmailAddress.error = "Email Harus Terisi"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextTextEmailAddress.error = "Email Tidak Falid"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (kata_sandi.isEmpty()) {
                binding.editTextTextPassword2.error = "Kata Sandi Harus Terisi"
                binding.editTextTextPassword2.requestFocus()
                return@setOnClickListener
            }

            if (kata_sandi.length < 8) {
                binding.editTextTextPassword2.error = "Kata Sandi Minimal Terdiri 8 Karakter"
                binding.editTextTextPassword2.requestFocus()
                return@setOnClickListener
            }

            if (konfirm_pass.isEmpty()) {
                binding.editTextTextEmailAddress.error = "Konfirmasi Kata Sandi Harus Terisi"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            val pengguna = Pengguna(nik, nama, alamat, ttl, telp, pekerjaan, pp, email, kata_sandi)
            saveData(pengguna)
            DaftarFirebase(email,kata_sandi)
        }

        val btnTakePicture = findViewById<Button>(R.id.btnUploadpp)
        btnTakePicture.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    CAMERA_REQUEST_CODE
                )
            }
        }

        var syarat: TextView? = null
        syarat = findViewById(R.id.syarat)
        syarat?.setOnClickListener{
            startActivity(Intent(this, TermsAndConditionActivity::class.java))
        }
    }



    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.btnUploadpp.isEnabled = false
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CAMERA_PERMISSION_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera()
        }
    }

    private fun saveData(pengguna : Pengguna) {
        val ref = FirebaseDatabase.getInstance().getReference("pengguna")
        val nik = ref.push().key

        if (nik != null) {
            ref.child(nik).setValue(pengguna).addOnCompleteListener{

            }
        }
    }

    private fun DaftarFirebase(email: String, kataSandi: String) {

        auth.createUserWithEmailAndPassword(email, kataSandi)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}


