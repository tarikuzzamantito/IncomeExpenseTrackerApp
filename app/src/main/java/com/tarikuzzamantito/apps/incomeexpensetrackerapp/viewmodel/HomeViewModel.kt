package com.tarikuzzamantito.apps.incomeexpensetrackerapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.InExDatabase
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.dao.InExDao
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model.InExEntity

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 12:45 AM
 */
class HomeViewModel(dao: InExDao) : ViewModel() {
    val allinex = dao.getAllInEx()

    fun getBalance(list: List<InExEntity>): String {
        var total = 0.0
        list.forEach { inex ->
            if (inex.type == "Income") {
                total += inex.amount
            } else {
                total -= inex.amount
            }
        }
        return "$ $total"
    }

    fun getTotalIncome(list: List<InExEntity>): String {
        var totalIn = 0.0
        list.forEach { inex ->
            if (inex.type == "Income") {
                totalIn += inex.amount
            }
        }
        return "$ $totalIn"
    }

    fun getTotalExpense(list: List<InExEntity>): String {
        var totalEx = 0.0
        list.forEach { inex ->
            if (inex.type == "Expense") {
                totalEx += inex.amount
            }
        }
        return "$ $totalEx"
    }
}

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = InExDatabase.getDatabase(context).inexDao()
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}