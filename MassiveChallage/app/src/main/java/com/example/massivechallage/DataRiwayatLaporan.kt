package com.example.massivechallage

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

// Model
@Parcelize
data class DataRiwayatLaporan(
    val jenisLaporan: String,
    val tanggalLapor: String,
    val alamatPelapor: String,
    val statusLaporan: Int,
    val statuswarLaporan: Int
) : Parcelable {
    companion object {
        val statusLaporan: CharSequence?
            get() {
                TODO()
            }
        val alamatPelapor: CharSequence?
            get() {
                TODO()
            }
        val tanggalLapor: CharSequence?
            get() {
                TODO()
            }
        val jenisLaporan: CharSequence?
            get() {
                TODO()
            }
    }

    // Get a reference to the Firestore database
    private val database: FirebaseFirestore = FirebaseFirestore.getInstance()

    // Get a reference to the "riwayatLaporan" collection
    private val riwayatLaporanCollection: CollectionReference = database.collection("riwayatLaporan")

    fun saveData(data: DataRiwayatLaporan) {
        // Add a new document to the "riwayatLaporan" collection
        riwayatLaporanCollection.add(data)
            .addOnSuccessListener { documentReference ->
                // Data saved successfully
            }
            .addOnFailureListener { error ->
                // Error occurred while saving data
            }
    }

    fun getDataFromFirestore() {
        // Attach a SnapshotListener to the "riwayatLaporan" collection
        riwayatLaporanCollection
            .orderBy("tanggalLapor") // Order by "tanggalLapor" field
            .addSnapshotListener { snapshot: QuerySnapshot?, exception: Exception? ->
                if (exception != null) {
                    // Error occurred while retrieving data
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    // Get the documents from the snapshot and iterate through them
                    for (document in snapshot.documents) {
                        // Get the DataRiwayatLaporan object from the document
                        val data = document.toObject(DataRiwayatLaporan::class.java)
                        if (data != null) {
                            // Process the data
                        }
                    }
                }
            }
    }
}
