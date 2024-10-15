package com.gilberson.presentation.controllers

import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.repository.PlayerRepository
import com.gilberson.domain.repository.TeamRepository

class TeamController(private val teamRepository: TeamRepository, private val playerRepository: PlayerRepository) {

    suspend fun getAllTeams(): List<TeamModel> {
        return teamRepository.getListTeam()
    }

    suspend fun createTeam(team: TeamModel) {
        return teamRepository.saveTeam(team)
    }

    suspend fun getTeamById(id: String): TeamModel {
        val team=teamRepository.getTeam(id)
        team?.let {
            return it
        }?:throw CustomExceptions.NotFoundException("Team not found")

    }

    suspend fun addPlayerToTeam(idPlayer: String, idTeam: String): TeamModel {
        val player = playerRepository.getPlayer(idPlayer)
        player?.let {

            throw CustomExceptions.NotFoundException("Feature not yet implemented")
        } ?: throw CustomExceptions.NotFoundException("Player $idPlayer not found")
    }
}
