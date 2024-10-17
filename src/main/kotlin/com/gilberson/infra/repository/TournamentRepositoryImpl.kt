package com.gilberson.infra.repository

import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.model.TournamentModel
import com.gilberson.domain.repository.TournamentRepository
import com.gilberson.infra.database.entity.*
import com.gilberson.infra.extensions.suspendTransaction
import com.gilberson.infra.mapping.toModel
import org.jetbrains.exposed.sql.SizedCollection

class TournamentRepositoryImpl : TournamentRepository {
    override suspend fun getAllTournaments(): List<TournamentModel> = suspendTransaction {
        TournamentDao.all().map { it.toModel() }
    }

    override suspend fun getTournament(id: String): TournamentModel? = suspendTransaction {
        TournamentDao.find {
            (TournamentTable.id eq id.toInt())
        }.limit(1).map { it.toModel() }.firstOrNull()
    }

    override suspend fun createTournament(tournament: TournamentModel): TournamentModel = suspendTransaction {
        TournamentDao.new {
            name = tournament.name
        }.toModel()
    }

    override suspend fun addTeamOnTournament(teamId: String, tournamentId: String) = suspendTransaction {
        val team = TeamDao.find { (TeamTable.id eq teamId.toInt()) }.firstOrNull()
        if (team == null) {
            throw CustomExceptions.NotFoundException("Team with id $teamId not found")
        }
        val tournament = TournamentDao.find { (TournamentTable.id eq tournamentId.toInt()) }.firstOrNull()
        if (tournament == null) {
            throw CustomExceptions.NotFoundException("Team with id $tournamentId not found")
        }
        team.tournaments = SizedCollection(team.tournaments + tournament)
    }

    override suspend fun getTeams(id: String): List<TeamModel> = suspendTransaction {
        TournamentDao.find { TournamentTable.id eq id.toInt() }.firstOrNull()?.teams?.map { it.toModel() }
            ?: emptyList()
    }
}

