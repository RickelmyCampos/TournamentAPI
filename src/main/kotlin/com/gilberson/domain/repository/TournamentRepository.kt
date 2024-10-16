package com.gilberson.domain.repository


import com.gilberson.domain.model.TournamentModel
interface TournamentRepository {
    suspend fun getAllTournaments(): List<TournamentModel>
    suspend fun getTournament(id: String): TournamentModel?
    suspend fun createTournament(tournament: TournamentModel):TournamentModel
    suspend fun addTeamOnTournament(teamId: String, tournamentId: String)
}
//class TournamentRepository {
//    fun getAllTournaments(): List<TournamentModel> {
//        return listTournament
//    }
//
//    fun getTournamentById(id: String): TournamentModel {
//        val team: TournamentModel? = listTournament.find { it.id == id }
//        team?.let {
//            return it
//        } ?: throw CustomExceptions.NotFoundException("Tournament not found")
//    }
//
//    fun createTournament(tournament: TournamentModel): TournamentModel {
//        listTournament.add(tournament)
//        return tournament
//    }
//    fun addTeamOnTournament(team: TeamModel, idTournament:String): TeamModel {
//        val tournament=getTournamentById(idTournament)
//        tournament.listTeams.add(team)
//        return team
//    }
//
//}