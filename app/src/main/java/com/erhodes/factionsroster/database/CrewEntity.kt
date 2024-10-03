package com.erhodes.factionsroster.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CrewEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "crew_type") val crewType: String
)