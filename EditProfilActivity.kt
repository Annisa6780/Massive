package com.example.massivechallage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class EditProfilActivity : AppCompatActivity() {

    private lateinit var namaEditText: EditText
    private lateinit var nikEditText: EditText
    private lateinit var alamatEditText: EditText
    private lateinit var tanggalLahirEditText: EditText
    private lateinit var jenisKelaminEditText: EditText
    private lateinit var noTelpEditText: EditText
    private lateinit var pekerjaanEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var konfirmasiPasswordEditText: EditText
    private lateinit var simpanButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        namaEditText = findViewById(R.id.ed_nama)
        nikEditText = findViewById(R.id.editTextNumber)
        alamatEditText = findViewById(R.id.ed_alamat)
        tanggalLahirEditText = findViewById(R.id.editTextDate)
        jenisKelaminEditText = findViewById(R.id.radioButton1)
        noTelpEditText = findViewById(R.id.editTextPhone)
        pekerjaanEditText = findViewById(R.id.ed_pekerjaan)
        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword2)
        konfirmasiPasswordEditText = findViewById(R.id.editTextTextPassword3)
        simpanButton = findViewById(R.id.btnDaftar)

        simpanButton.setOnClickListener {
            saveDataToFirebase()
        }
    }

    private fun saveDataToFirebase() {
        val database = FirebaseDatabase.getInstance()
        val ref = database.reference.child("profil")

        val nama = namaEditText.text.toString()
        val nik = nikEditText.text.toString()
        val alamat = alamatEditText.text.toString()
        val tanggalLahir = tanggalLahirEditText.text.toString()
        val jenisKelamin = jenisKelaminEditText.text.toString()
        val noTelp = noTelpEditText.text.toString()
        val pekerjaan = pekerjaanEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val konfirmasiPassword = konfirmasiPasswordEditText.text.toString()

        val profilData = HashMap<String, Any>()
        profilData["nama"] = nama
        profilData["nik"] = nik
        profilData["alamat"] = alamat
        profilData["tanggalLahir"] = tanggalLahir
        profilData["jenisKelamin"] = jenisKelamin
        profilData["noTelp"] = noTelp
        profilData["pekerjaan"] = pekerjaan
        profilData["email"] = email
        profilData["password"] = password
        profilData["konfirmasiPassword"] = konfirmasiPassword

        val profilKey = ref.push().key
        if (profilKey != null) {
            ref.child(profilKey).setValue(profilData)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Data saved successfully
                    } else {
                        // Failed to save data
                    }
                }
        }
    }
}