package com.adryanev.dicoding.hewanlangka.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adryanev.dicoding.hewanlangka.data.HewanRepository
import com.adryanev.dicoding.hewanlangka.data.entities.Hewan

class MainViewModel internal constructor(hewanRepository: HewanRepository) : ViewModel() {

    val hewans: LiveData<List<Hewan>> = hewanRepository.getHewanList()
}
