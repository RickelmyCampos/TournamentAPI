package com.gilberson.presentation.controllers

import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.model.TournamentModel
import com.gilberson.domain.repository.PlayerRepository
import com.gilberson.domain.repository.TeamRepository
import com.gilberson.domain.repository.TournamentRepository

class TournamentController(
    private val tournamentRepository: TournamentRepository,
    private val teamRepository: TeamRepository
) {

    suspend fun getAllTournaments(): List<TournamentModel> {
        return tournamentRepository.getAllTournaments()
    }

    suspend fun createTournament(team: TournamentModel): TournamentModel {
        return tournamentRepository.createTournament(team)
    }

    suspend fun getTournamentById(id: String): TournamentModel {
        val tournament = tournamentRepository.getTournament(id)
        tournament?.let {
            return it
        } ?: throw CustomExceptions.NotFoundException("Tournament not found")

    }

    suspend fun addTeamToTournament(idTeam: String, idTournament: String) {
        val team = tournamentRepository.addTeamOnTournament(idTeam, idTournament)
       // throw CustomExceptions.NotFoundException("Feature not yet implemented")
    }
}