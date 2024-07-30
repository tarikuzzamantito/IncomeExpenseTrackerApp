package com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 10:09 AM
 */
@Entity(tableName = "data_table")
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val title: String,
    val amount: Double,
    val date: Long,
    val category: String,
    val type: String
)
