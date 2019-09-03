package com.adryanev.dicoding.hewanlangka.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.adryanev.dicoding.hewanlangka.data.HewanDatabase
import com.adryanev.dicoding.hewanlangka.data.entities.Hewan
import com.adryanev.dicoding.hewanlangka.utils.Constant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import timber.log.Timber

class SeedDatabaseWorker(context: Context, workerParams:WorkerParameters) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result  = coroutineScope {
        try{
            applicationContext.assets.open(Constant.HEWAN_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val hewanType = object : TypeToken<List<Hewan>>() {}.type
                    val hewanList: List<Hewan> = Gson().fromJson(jsonReader, hewanType)

                    val database = HewanDatabase.getInstance(applicationContext)
                    database.hewanDao().insertAll(hewanList)

                    Result.success()
                }
            }
        }catch (ex: Exception){
            Timber.e("Error seeding database: ${ex.localizedMessage}")
            Result.failure()
        }
    }
}