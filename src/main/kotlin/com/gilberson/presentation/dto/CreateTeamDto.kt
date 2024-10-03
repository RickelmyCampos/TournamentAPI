package com.gilberson.presentation.dto

import com.gilberson.domain.model.PlayerModel
import com.gilberson.domain.model.TeamModel
import kotlinx.serialization.Serializable

@Serializable
data class CreateTeamDto(
    val id: String,
    val name: String,
    val description: String,
    val modality: String
)

fun CreateTeamDto.toTeamModel(): TeamModel {
    return TeamModel(id, name, description, modality, mutableListOf<PlayerModel>())
}

