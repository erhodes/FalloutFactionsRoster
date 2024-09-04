package com.erhodes.factionsroster.data

class Crew(val crewType: CrewType) {

    var crewName = ""
    val crewFaction = crewType.name
    var playerName = ""
    var gamesPlayed = 0
    var reputation = 0
    var tempReputation = 0

    val models = ArrayList<Model>(0)

    fun addModel(model: Model) {
        models.add(model)
        reputation+=model.rating
    }
}