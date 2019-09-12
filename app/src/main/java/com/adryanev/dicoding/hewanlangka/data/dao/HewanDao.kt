package com.adryanev.dicoding.hewanlangka.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adryanev.dicoding.hewanlangka.data.entities.Hewan

@Dao
interface HewanDao {


    @Query("SELECT * FROM hewan ORDER BY nama LIMIT 10")
    fun getHewanList(): LiveData<List<Hewan>>

    @Query("SELECT * FROM hewan WHERE id=:id LIMIT 1")
    fun getHewan(id:Int): LiveData<Hewan>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(hewans: List<Hewan>)

}