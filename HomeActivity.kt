package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inisialisasi Firebase Authentication
        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            // Pengguna sudah masuk, lanjutkan ke halaman utama
            // ...
        } else {
            // Pengguna belum masuk, arahkan ke halaman login atau tindakan yang sesuai
            // ...
        }
    }

    // ...
}