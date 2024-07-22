package com.erhodes.factionsroster.data

class Crew(val crewType: CrewType) {

    var crewName = ""
    val crewFaction = ""
    var playerName = ""
    var gamesPlayed = 0
    var reputation = 250
    var tempReputation = 250

    val models = ArrayList<Model>(0)
}