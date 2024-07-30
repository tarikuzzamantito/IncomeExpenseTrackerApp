package com.tarikuzzamantito.apps.incomeexpensetrackerapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.AppDatabase
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.dao.DataDao
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model.DataEntity

/**
 * Created by Tarikuzzaman Tito on 7/30/2024 11:20 PM
 */
class AddExpenseViewModel(val dao: DataDao) : ViewModel() {

    suspend fun addData(dataEntity: DataEntity): Boolean {
        return try {
            dao.insertData(dataEntity)
            true
        } catch (ex: Throwable) {
            false
        }
    }
}


class AddExpenseViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddExpenseViewModel::class.java)) {
            val dao = AppDatabase.getDatabase(context).dataDao()
            @Suppress("UNCHECKED_CAST")
            return AddExpenseViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}