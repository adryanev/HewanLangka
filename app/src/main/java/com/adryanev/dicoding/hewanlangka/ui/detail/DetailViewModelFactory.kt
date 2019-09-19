package com.adryanev.dicoding.hewanlangka.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adryanev.dicoding.hewanlangka.data.HewanRepository

/**
 * Project: HewanLangka
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 19/09/19
 * Time: 20:43
 */
class DetailViewModelFactory(private val hewanRepository: HewanRepository, private val idHewan:Int?) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun<T: ViewModel?> create(modelClass: Class<T>): T
    {
        return DetailViewModel(hewanRepository, idHewan) as T
    }
}