package com.adryanev.dicoding.hewanlangka.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hewan")
data class Hewan (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var nama: String? = "",
    var kingdom: String? = "",
    var filum: String? ="",
    var kelas: String? ="",
    var ordo: String? ="",
    var famili: String? = "",
    var genus: String? ="",
    var spesies: String? ="",
    var gambar: String? = "",
    var status: String? = "",
    var deskripsi: String? = ""
)