package com.erhodes.factionsroster.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ModelEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun modelDao(): ModelDao
}