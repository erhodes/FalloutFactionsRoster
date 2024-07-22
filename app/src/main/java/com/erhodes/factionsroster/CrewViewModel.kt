package com.erhodes.factionsroster

import androidx.lifecycle.ViewModel
import com.erhodes.factionsroster.data.Crew
import com.erhodes.factionsroster.data.CrewType
import com.erhodes.factionsroster.data.ModelClass
import com.erhodes.factionsroster.data.Weapon
import com.erhodes.factionsroster.data.WeaponLoadout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CrewViewModel: ViewModel() {

    private val _activeCrew = MutableStateFlow<Crew?>(null)
    val activeCrew: StateFlow<Crew?> = _activeCrew

    init {
        buildDefaults()
    }

    fun setActiveCrew(crew: Crew) {
        _activeCrew.update { crew }
    }

    fun buildDefaults() {
        val launcher = Weapon("Missile Launcher")
        launcher.test = "6S"
        launcher.traits = "Area 3, Slow"
        launcher.criticalEffect = "Maim"

        val combatRifle = Weapon("Combat Rifle")
        combatRifle.test = "4P"
        combatRifle.traits = "Fast"
        combatRifle.criticalEffect = "Maim"

        val launcherLoadout = WeaponLoadout(listOf(launcher), 48)
        val rifleLoadout = WeaponLoadout(listOf(combatRifle), 27)

        val madeMan = ModelClass("Made Man", arrayListOf(4,6,4,4,5,4,2), arrayListOf(launcherLoadout))
        val scavver = ModelClass("Scavver", arrayListOf(3,4,4,4,5,3,2), arrayListOf(rifleLoadout))

        val operators = CrewType(name = "Operators", listOf(madeMan, scavver))

        val theCrew = Crew(operators)

        setActiveCrew(theCrew)
    }
}