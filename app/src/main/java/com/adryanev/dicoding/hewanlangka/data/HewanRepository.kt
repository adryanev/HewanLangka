package com.adryanev.dicoding.hewanlangka.data

import com.adryanev.dicoding.hewanlangka.data.dao.HewanDao

class HewanRepository private constructor(private val hewanDao: HewanDao){

    fun getHewanList() = hewanDao.getHewanList()
    fun getHewan(id: Int) = hewanDao.getHewan(id)


    companion object{
        @Volatile private var instance: HewanRepository? = null

        fun getInstance(hewanDao: HewanDao) = instance ?: synchronized(this){
            instance ?: HewanRepository(hewanDao).also { instance = it }
        }
    }

}