package com.erhodes.factionsroster.data

import com.erhodes.factionsroster.data.GameData.Weapons.COMBAT_RIFLE
import com.erhodes.factionsroster.data.GameData.Weapons.MISSILE_LAUNCHER
import com.erhodes.factionsroster.data.GameData.Weapons.SYRINGER

object GameData {
    // I'm undecided if enums make sense. It's a little akward to do Class.weapon instead of just Weapon, but it does have the to&from string built in
    object Weapons {
        val COMBAT_RIFLE = Weapon("Combat Rifle", "4P", "Fast", "Maim")
        val SYRINGER = Weapon("Syringer", "2P", "Aim 2", "Poison 3")
        val MISSILE_LAUNCHER = Weapon("Missile Launcher", "4S", "Area 3, Slow", "Maim")
    }

    enum class Whatever(val weapon: Weapon) {
        COMBAT_RIFLE(Weapon("Combat Rifle", "4P", "Fast", "Maim"))
    }

    enum class EnumClasses(val modelClass: ModelClass) {
        SCAVVER(ModelClass("Scavver", arrayListOf(3,4,4,4,5,3,2), arrayListOf(WeaponLoadout(COMBAT_RIFLE, 27))))
    }

    object Classes {
        val MADE_MAN = ModelClass("Made Man", arrayListOf(4,6,4,4,5,4,2), arrayListOf(
            WeaponLoadout(SYRINGER, 31),
            WeaponLoadout(COMBAT_RIFLE, 33),
            WeaponLoadout(MISSILE_LAUNCHER, 48))
        )
        val SCAVVER = ModelClass("Scavver", arrayListOf(3,4,4,4,5,3,2), arrayListOf(WeaponLoadout(COMBAT_RIFLE, 27)))
    }
//    enum class Weapons(val weapon: com.erhodes.factionsroster.data.Weapon) {
//        COMBAT_RIFLE(Weapon("Combat Rifle"))
//    }
}