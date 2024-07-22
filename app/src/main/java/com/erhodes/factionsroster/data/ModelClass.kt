package com.erhodes.factionsroster.data

/**
 * A template for creating a new model
 */
class ModelClass(
    val name: String,
    val special: ArrayList<Int>,
    val loadouts: ArrayList<WeaponLoadout>,
    val perks: String = ""
) {

    //todo needs to have weapon loadout options
}