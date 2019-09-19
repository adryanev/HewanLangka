package com.adryanev.dicoding.hewanlangka.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adryanev.dicoding.hewanlangka.data.HewanRepository
import com.adryanev.dicoding.hewanlangka.data.entities.Hewan
import kotlinx.coroutines.cancel

class DetailViewModel (hewanRepository: HewanRepository, private val idHewan:Int?) : ViewModel() {

    val hewan: LiveData<Hewan> = hewanRepository.getHewan(idHewan!!)

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
