package com.erhodes.factionsroster

import androidx.lifecycle.ViewModel
import com.erhodes.factionsroster.data.Crew
import com.erhodes.factionsroster.data.CrewRepository
import com.erhodes.factionsroster.data.Model
import com.erhodes.factionsroster.data.ModelClass
import com.erhodes.factionsroster.data.WeaponLoadout
import kotlinx.coroutines.flow.StateFlow

class CrewViewModel: ViewModel() {

    private val repository: CrewRepository
        get() = RosterApplication.crewRepository

    var selectedModelClass: ModelClass? = null
    val activeCrewFlow: StateFlow<Crew?> = repository.activeCrewFlow

    init {
//        setActiveCrew(CrewRepository.buildDefaults())
    }

    fun setActiveCrew(crew: Crew) {
        repository.setActiveCrew(crew)
    }

    fun addModel(loadout: WeaponLoadout) {
        selectedModelClass?.let {
            repository.addModelToActiveCrew(Model(it.name, it, loadout))
        }
    }
}