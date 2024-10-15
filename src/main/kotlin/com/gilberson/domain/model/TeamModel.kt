package com.gilberson.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TeamModel(
    val id: String,
    val name: String,
    val description: String,
    val modality: String,
    val players: List<PlayerModel>
)
