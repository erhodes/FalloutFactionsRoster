package com.erhodes.factionsroster.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ModelDao {
    @Query("SELECT * FROM ModelEntity")
    fun getAll(): List<ModelEntity>

    @Insert
    fun insert(modelEntity: ModelEntity)
}