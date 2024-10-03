package com.erhodes.factionsroster.data

import androidx.room.util.query
import com.erhodes.factionsroster.MainActivity
import com.erhodes.factionsroster.database.DatabaseWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CrewRepository(val database: DatabaseWrapper, private val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)) {

    private var activeCrew: Crew? = null

    private val _activeCrewFlow = MutableStateFlow<Crew?>(null)
    val activeCrewFlow: StateFlow<Crew?> = _activeCrewFlow

    init {
        // load in all saved models and add them to the default crew
        // todo have different crews too

        setActiveCrew(buildDefaults())
        scope.launch(Dispatchers.IO) {
            val savedModels = database.loadModels()
            savedModels.forEach {
                activeCrew!!.addModel(it)
                _activeCrewFlow.update {
                    activeCrew
                }
            }
        }
    }

    fun setActiveCrew(crew: Crew) {
        activeCrew = crew
        _activeCrewFlow.update { activeCrew }
    }

    fun addModelToActiveCrew(model: Model) {
        activeCrew?.let { crew ->
            crew.addModel(model)
            saveModel(model)
            _activeCrewFlow.update {
                activeCrew
            }
        }
    }

    private fun saveModel(model: Model) {
        scope.launch(Dispatchers.IO) {
            database.saveModel(model)
        }
    }

    companion object {
        fun buildDefaults(): Crew {
            val madeMan = GameData.Classes.MADE_MAN
            val scavver = GameData.Classes.SCAVVER

            val operators = CrewType(name = "Operators", listOf(madeMan, scavver))

            val theCrew = Crew(operators)
            theCrew.crewName = "Test Operators"

            return theCrew
        }
    }

}