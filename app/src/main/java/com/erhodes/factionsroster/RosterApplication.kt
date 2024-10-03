package com.erhodes.factionsroster

import android.app.Application
import androidx.room.Room
import com.erhodes.factionsroster.MainActivity.Companion.database
import com.erhodes.factionsroster.data.CrewRepository
import com.erhodes.factionsroster.database.AppDatabase
import com.erhodes.factionsroster.database.DatabaseWrapper

class RosterApplication : Application() {

    companion object {
        lateinit var databaseWrapper: DatabaseWrapper
        lateinit var crewRepository: CrewRepository
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "roster-database"
        ).build()

        databaseWrapper = DatabaseWrapper(database)
        crewRepository = CrewRepository(databaseWrapper)
    }
}