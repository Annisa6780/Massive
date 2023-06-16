package com.example.massivechallage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.massivechallage.databinding.ActivityDaftarBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

/*private var RadioGroup.error: String
    get() {}
    set() {}*/

class DaftarActivity : AppCompatActivity() {

    lateinit var  binding: ActivityDaftarBinding
    lateinit var auth : FirebaseAuth

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
            //bagian upload surat pernyayaan blm
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
            //kondisi jika konfirm pass tidak sama dgn pass?

            DaftarFirebase(email,kata_sandi)
        }

        

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)

            // Dapatkan teks dari RadioButton yang dipilih
            val selectedText = radioButton.text.toString()

            // Lakukan sesuatu dengan teks yang dipilih
            Toast.makeText(this, "Anda memilih: $selectedText", Toast.LENGTH_SHORT).show()
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


