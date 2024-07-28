package com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model

import androidx.room.Entity

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 12:30 AM
 */
@Entity(tableName = "inex_table")
data class InExEntity(
    val id: Int,
    val title: String,
    val amount: Double,
    val data: Long,
    val category: String,
    val type: String
)