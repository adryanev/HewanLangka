package com.adryanev.dicoding.hewanlangka.utils

import android.content.Context
import com.adryanev.dicoding.hewanlangka.data.HewanDatabase
import com.adryanev.dicoding.hewanlangka.data.HewanRepository
import com.adryanev.dicoding.hewanlangka.ui.detail.DetailViewModelFactory
import com.adryanev.dicoding.hewanlangka.ui.main.MainViewModelFactory

/**
 * Project: HewanLangka
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 19/09/19
 * Time: 18:16
 */
object InjectorUtils {

    private fun getHewanRepository(context: Context) : HewanRepository{
        return HewanRepository.getInstance(HewanDatabase.getInstance(context).hewanDao())
    }

    fun provideMainViewModelFactory(context: Context) :MainViewModelFactory{
        val repo = getHewanRepository(context);
        return MainViewModelFactory(repo)
    }

    fun provideDetailViewModelFactory(context: Context, idHewan:Int?) : DetailViewModelFactory{
        return DetailViewModelFactory(getHewanRepository(context), idHewan)
    }
}