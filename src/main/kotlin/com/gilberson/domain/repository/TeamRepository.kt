package com.gilberson.domain.repository

import com.gilberson.domain.model.TeamModel
interface TeamRepository {
    suspend fun saveTeam(team: TeamModel)
    suspend fun getTeam(teamId: String): TeamModel?
    suspend fun getListTeam(): List<TeamModel>
    suspend fun addPlayerOnTeam(playerId: String, teamId: String)
}