package com.erhodes.factionsroster.data

/**
 * A possible set of weapons for a model class
 */
class WeaponLoadout(
    val weapons: List<Weapon>,
    val rating: Int
) {
    constructor(weapon: Weapon, rating: Int) : this(arrayListOf(weapon), rating)
}