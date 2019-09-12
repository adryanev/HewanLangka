package com.adryanev.dicoding.hewanlangka.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.adryanev.dicoding.hewanlangka.data.dao.HewanDao
import com.adryanev.dicoding.hewanlangka.data.entities.Hewan
import com.adryanev.dicoding.hewanlangka.utils.Constant.DATABASE_NAME
import com.adryanev.dicoding.hewanlangka.workers.SeedDatabaseWorker

@Database(entities = [Hewan::class],version = 1, exportSchema = false)
abstract class HewanDatabase : RoomDatabase(){

    abstract fun hewanDao() : HewanDao

    companion object{
        @Volatile private var instance: HewanDatabase? = null;

        fun getInstance(context: Context): HewanDatabase{
            return instance ?: synchronized(this){
                instance?: buildDatabase(context).also{ instance = it}
            }
        }

        private fun buildDatabase(context: Context) : HewanDatabase {
            return Room.databaseBuilder(context,HewanDatabase::class.java, DATABASE_NAME).
                addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                }).build()
        }
    }
}