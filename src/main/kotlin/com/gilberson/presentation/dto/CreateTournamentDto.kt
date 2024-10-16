package com.gilberson.presentation.dto

import com.gilberson.domain.model.Disputes
import com.gilberson.domain.model.TournamentModel
import kotlinx.serialization.Serializable

@Serializable
data class CreateTournamentDto(val id: String, val name: String)

fun CreateTournamentDto.toModel(): TournamentModel {
    return TournamentModel(
        id = id,
        name = name,
        listTeams = mutableListOf(),
        initialDate = "",
        finalDate = "",
        gameTournament = "",
        status = "",
        disputeType = Disputes.Elimination
    )
}
