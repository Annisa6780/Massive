package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database

class AkunActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var userReference: DatabaseReference
    private lateinit var userListener: ValueEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        auth = FirebaseAuth.getInstance()
        val currentUser: FirebaseUser? = auth.currentUser

        userReference = FirebaseDatabase.getInstance().getReference("users")
            .child(currentUser?.uid ?: "")

        userListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)
                // Update UI with user data
                // Misalnya: tv_namaprofil.text = user?.name
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        }

        userReference.addValueEventListener(userListener)

        // ...
    }

    override fun onDestroy() {
        super.onDestroy()
        userReference.removeEventListener(userListener)
    }

        // ...

}