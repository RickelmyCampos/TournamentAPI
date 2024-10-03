package com.gilberson.presentation.controllers

import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.repository.PlayerRepository
import com.gilberson.domain.repository.TeamRepository

class TeamController(private val teamRepository: TeamRepository,private val playerRepository: PlayerRepository) {

    fun getAllTeams(): List<TeamModel> {
        return teamRepository.getTeamList()
    }
    fun createTeam(team:TeamModel) {
        return teamRepository.saveTeam(team)
    }
    fun getTeamById(id:String): TeamModel {
        return teamRepository.getTeamById(id)
    }
    fun addPlayerToTeam(idPlayer:String,idTeam:String):TeamModel {
        val player=playerRepository.getPlayer(idPlayer)
       return teamRepository.addPlayerOnTeam(player,idTeam)
    }
}
