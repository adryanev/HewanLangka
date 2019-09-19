package com.adryanev.dicoding.hewanlangka.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adryanev.dicoding.hewanlangka.data.HewanRepository

/**
 * Project: HewanLangka
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 19/09/19
 * Time: 13:26
 */
class MainViewModelFactory (private val repository: HewanRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T: ViewModel?> create(modelClass: Class<T>) = MainViewModel(repository) as T
}