package com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model.InExEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 12:33 AM
 */
@Dao
interface InExDao {

    @Query("SELECT * FROM inex_table")
    fun getAllInEx(): Flow<List<InExEntity>>

    @Insert
    suspend fun insertInEx(inExEntity: InExEntity)

    @Delete
    suspend fun deleteInEx(inExEntity: InExEntity)

    @Update
    suspend fun updateInEx(inExEntity: InExEntity)

}