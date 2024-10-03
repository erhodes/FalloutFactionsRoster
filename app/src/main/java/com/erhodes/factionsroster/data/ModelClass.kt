package com.erhodes.factionsroster.data

/**
 * A template for creating a new model
 */
class ModelClass(
    val name: String,
    val special: ArrayList<Int>,
    val loadouts: ArrayList<WeaponLoadout>,
    val type: String = "Grunt",
    val perks: String = ""
) {

    companion object {
        fun convertToString(modelClass: ModelClass) {

        }
        fun fromString(name: String): ModelClass {
            return when (name) {
                "Scavver" -> {GameData.Classes.SCAVVER}
                "Made Man" -> {GameData.Classes.MADE_MAN}
                else -> {GameData.Classes.SCAVVER}
            }
        }
    }
    //todo needs to have weapon loadout options
}