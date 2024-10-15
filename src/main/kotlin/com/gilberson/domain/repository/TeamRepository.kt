package com.gilberson.domain.repository

import com.gilberson.DatabaseStore.listTeam
import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.PlayerModel
import com.gilberson.domain.model.TeamModel
interface TeamRepository {
    suspend fun saveTeam(team: TeamModel)
    suspend fun getTeam(teamId: String): TeamModel?
    suspend fun getListTeam(): List<TeamModel>
}
//class TeamRepository {
//    fun saveTeam(team: TeamModel) {
//        listTeam.add(team)
//    }
//
//    fun getTeamList(): List<TeamModel> = listTeam
//    fun getTeamById(id: String): TeamModel {
//        val team: TeamModel? = listTeam.find { it.id == id }
//        team?.let {
//            return it
//        } ?: throw CustomExceptions.NotFoundException("Team not found")
//    }
//    fun addPlayerOnTeam(player:PlayerModel,idTeam:String): TeamModel {
//        val team=getTeamById(idTeam)
//        team.players.add(player)
//        return team
//    }
//}