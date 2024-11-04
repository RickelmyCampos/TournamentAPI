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
        listTeams.shuffled()
        var clash: MutableList<Pair<TeamModel, TeamModel>> = mutableListOf()
        for (i in listTeams.indices step 2) {
            clash.add(listTeams[i] to listTeams[i+1])
        }
        clash.forEach {
            clashRepository.saveClash(
                ClashModel(
                    id = "0",
                    status = "Iniciado",
                    result = "0",
                    date = "hoje",
                    tournamentId = tournament.id,
                    teamOneId = it.first.id,
                    teamTwoId =  it.second.id
                )
            )
        }

    }
}