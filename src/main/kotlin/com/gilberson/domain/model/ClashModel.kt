package com.gilberson.domain.model

data class ClashModel(
    val id: String,
    val date: String,
    val tournament: TournamentModel,
    val teamOne: TeamModel,
    val teamTwo: TeamModel,
    val result: String,
    val status: String
)