package com.gilberson.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TournamentModel(val id:String,val name:String,val listTeams:MutableList<TeamModel>)
