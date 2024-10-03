package com.erhodes.factionsroster.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ModelEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "model_name") val name: String,
    @ColumnInfo(name = "model_class") val modelClass: String,
    @ColumnInfo(name = "weapon_loadout") val loadout: Int
)