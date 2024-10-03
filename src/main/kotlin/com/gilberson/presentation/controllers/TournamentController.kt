package com.gilberson.presentation.controllers

import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.model.TournamentModel
import com.gilberson.domain.repository.PlayerRepository
import com.gilberson.domain.repository.TeamRepository
import com.gilberson.domain.repository.TournamentRepository

class TournamentController(private val tournamentRepository: TournamentRepository,private val teamRepository: TeamRepository) {

    fun getAllTournaments(): List<TournamentModel> {
        return tournamentRepository.getAllTournaments()
    }
    fun createTournament(team: TournamentModel):TournamentModel {
        return tournamentRepository.createTournament(team)
    }
    fun getTournamentById(id:String): TournamentModel {
        return tournamentRepository.getTournamentById(id)
    }
    fun addTeamToTournament(idTeam:String,idTournament:String): TeamModel {
        val team=teamRepository.getTeamById(idTeam)
        return tournamentRepository.addTeamOnTournament(team,idTournament)
    }
}