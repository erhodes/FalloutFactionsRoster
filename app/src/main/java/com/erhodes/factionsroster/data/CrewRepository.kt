package com.erhodes.factionsroster.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CrewRepository {

    private var activeCrew: Crew? = null

    private val _activeCrewFlow = MutableStateFlow<Crew?>(null)
    val activeCrewFlow: StateFlow<Crew?> = _activeCrewFlow

    fun setActiveCrew(crew: Crew) {
        activeCrew = crew
        _activeCrewFlow.update { activeCrew }
    }

    fun addModelToActiveCrew(model: Model) {
        activeCrew?.let { crew ->
            crew.addModel(model)

            _activeCrewFlow.update {
                activeCrew
            }
        }

    }

    companion object {
        fun buildDefaults(): Crew {
            val launcher = Weapon("Missile Launcher")
            launcher.test = "6S"
            launcher.traits = "Area 3, Slow"
            launcher.criticalEffect = "Maim"

            val combatRifle = Weapon("Combat Rifle")
            combatRifle.test = "4P"
            combatRifle.traits = "Fast"
            combatRifle.criticalEffect = "Maim"

            val syringer = Weapon("Syringer")
            syringer.test = "2P"
            syringer.traits = "Aim 2"
            syringer.criticalEffect = "Poison 3"

            val launcherLoadout = WeaponLoadout(listOf(launcher), 48)
            val syringerLoadout = WeaponLoadout(listOf(syringer), 31)
            val rifleLoadoutMade = WeaponLoadout(listOf(combatRifle), 33)

            val rifleLoadout = WeaponLoadout(listOf(combatRifle), 27)

            val madeMan = ModelClass("Made Man", arrayListOf(4,6,4,4,5,4,2), arrayListOf(syringerLoadout, rifleLoadoutMade, launcherLoadout))
            val scavver = ModelClass("Scavver", arrayListOf(3,4,4,4,5,3,2), arrayListOf(rifleLoadout))

            val operators = CrewType(name = "Operators", listOf(madeMan, scavver))

            val theCrew = Crew(operators)
            theCrew.crewName = "Test Operators"

            return theCrew
        }
    }

}