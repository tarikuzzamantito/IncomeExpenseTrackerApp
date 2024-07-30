package com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tarikuzzamantito.apps.incomeexpensetrackerapp.data.model.DataEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Tarikuzzaman Tito on 7/29/2024 10:12 AM
 */
@Dao
interface DataDao {

    @Query("SELECT * FROM data_table")
    fun getAllData(): Flow<List<DataEntity>>

    @Insert
    suspend fun insertData(dataEntity: DataEntity)

    @Delete
    suspend fun deleteData(dataEntity: DataEntity)

    @Update
    suspend fun updateData(dataEntity: DataEntity)
}