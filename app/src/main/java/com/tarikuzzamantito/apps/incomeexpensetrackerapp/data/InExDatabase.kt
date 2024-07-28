package com.tarikuzzamantito.apps.incomeexpensetrackerapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.dao.InExDao

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 12:29 AM
 * Figma Design: https://www.figma.com/community/file/1080339303735258826/income-expense-tracker-app
 * Reference: https://www.youtube.com/watch?v=LfHkAUzup5E&ab_channel=CodewithFK
 */
@Database(entities = [InExDatabase::class], version = 1)
abstract class InExDatabase : RoomDatabase() {
    abstract fun inexDao(): InExDao

    companion object {
        const val DATABASE_NAME = "inex_database"

        @JvmStatic
        fun getDatabase(context: Context): InExDatabase {
            return Room.databaseBuilder(
                context,
                InExDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}
