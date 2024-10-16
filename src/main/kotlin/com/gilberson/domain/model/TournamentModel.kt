package com.gilberson.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TournamentModel(
    val id: String,
    val name: String,
    val listTeams: List<TeamModel>,
    val initialDate: String,
    val finalDate: String,
    val status:String,
    val gameTournament: String,
    val disputeType:Disputes
)
enum class Disputes{
    Elimination,
    Groups,
    Both
}