package com.erhodes.factionsroster.data

class Model(val name: String, val modelClass: ModelClass, val loadout: WeaponLoadout) {

    var special = ArrayList<Int>(7)
    var currentHealth = 0
    var maxHealth = 1
    var weapons: List<Weapon>
    var rating = 0

    init {
        special = modelClass.special
        weapons = loadout.weapons
        rating = loadout.rating
    }
}