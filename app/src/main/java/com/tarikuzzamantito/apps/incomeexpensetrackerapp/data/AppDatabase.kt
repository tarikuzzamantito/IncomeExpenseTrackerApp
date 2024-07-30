package com.tarikuzzamantito.apps.incomeexpensetrackerapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.dao.DataDao
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model.DataEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 10:08 AM
 */

@Database(entities = [DataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao

    companion object {
        const val DATABASE_NAME = "app_database"

        @JvmStatic
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .addCallback(object : Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        initBasicData(context)
                    }
                    fun initBasicData(context: Context) {
                        CoroutineScope(Dispatchers.IO).launch {
                            val dao = getDatabase(context).dataDao()
                            dao.insertData(DataEntity(1, "Salary", 5000.80, System.currentTimeMillis(), "Salary", "Income"))
                            dao.insertData(DataEntity(2, "Paypal", 8000.30, System.currentTimeMillis(), "Salary", "Income"))
                            dao.insertData(DataEntity(3, "Netflix", 500.50, System.currentTimeMillis(), "Salary", "Expense"))
                            dao.insertData(DataEntity(4, "Starbucks", 400.20, System.currentTimeMillis(), "Salary", "Expense"))
                        }
                    }
                })
                .build()
        }
    }
}