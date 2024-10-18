package com.gilberson.application.usecases

import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.ClashModel
import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.repository.ClashRepository
import com.gilberson.domain.repository.TournamentRepository

class StartTournamentUseCase(
    private val tournamentRepository: TournamentRepository,
    private val clashRepository: ClashRepository
) {
    suspend operator fun invoke(id: String) {
        val tournament = tournamentRepository.getTournament(id)
            ?: throw CustomExceptions.NotFoundException("Tournament with id $id not found")
        val listTeams = tournamentRepository.getTeams(id)
        if (listTeams.size < 2) {
            throw CustomExceptions.BadRequestException("Teams size must be greater than 2")
        }
        clashRepository.saveClash(
            ClashModel(
                id = "",
                status = "",
                result = "",
                date = "",
                tournamentId = tournament.id,
                teamOneId = listTeams[0].id,
                teamTwoId = listTeams[1].id,
            )
        )
    }
}