package com.example.massivechallage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase


class EdukasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edukasi)

        // Initialize Firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("articles")

// Read data
    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // Process the retrieved data
            for (articleSnapshot in dataSnapshot.children) {
                val articleTitle = articleSnapshot.child("title").value as String
                val articleImage = articleSnapshot.child("image").value as String

                // Use the data as needed
                // e.g., display articleTitle and articleImage in your app's UI
            }
        }

        override fun onCancelled(error: DatabaseError) {
            // Handle error
        }
    })

}

