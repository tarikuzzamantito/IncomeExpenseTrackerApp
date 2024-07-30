package com.tarikuzzamantito.apps.incomeexpensetrackerapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.R
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.Utils
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.AppDatabase
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.dao.DataDao
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model.DataEntity

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 12:45 AM
 */
class HomeViewModel(dao: DataDao) : ViewModel() {
    val allData = dao.getAllData()

    fun getBalance(list: List<DataEntity>): String {
        var balance = 0.0
        list.forEach { data ->
            if (data.type == "Income") {
                balance += data.amount
            } else {
                balance -= data.amount
            }
        }
        return "$ ${Utils.formatDecimalToValue(balance)}"
    }

    fun getTotalIncome(list: List<DataEntity>): String {
        var totalIn = 0.0
        list.forEach { data ->
            if (data.type == "Income") {
                totalIn += data.amount
            }
        }
        return "$ ${Utils.formatDecimalToValue(totalIn)}"
    }

    fun getTotalExpense(list: List<DataEntity>): String {
        var totalEx = 0.0
        list.forEach { data ->
            if (data.type == "Expense") {
                totalEx += data.amount
            }
        }

        return "$ ${Utils.formatDecimalToValue(totalEx)}"
    }

    fun getItemIcon(item: DataEntity) : Int{
        if (item.category == "Paypal") {
            return R.drawable.ic_paypal
        } else if (item.category == "Netflix") {
            return R.drawable.ic_netflix
        } else if (item.category == "Starbucks") {
            return R.drawable.ic_starbucks
        }
        return R.drawable.ic_upwork
    }
}

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = AppDatabase.getDatabase(context).dataDao()
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
