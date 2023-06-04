package com.example.massivechallage

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//model
@Parcelize
data class DataRiwayatLaporan(
    val jenisLaporan : String,
    val tanggalLapor : String,
    val alamatPelapor : String,
    val statusLaporan : Int,
    val statuswarLaporan : Int
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
}
