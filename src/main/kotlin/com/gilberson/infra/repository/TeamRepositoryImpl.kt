package com.gilberson.infra.repository

import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.repository.TeamRepository
import com.gilberson.infra.database.entity.*
import com.gilberson.infra.extensions.suspendTransaction
import com.gilberson.infra.mapping.toModel
import org.jetbrains.exposed.sql.SizedCollection
class TeamRepositoryImpl : TeamRepository {
    override suspend fun saveTeam(team: TeamModel): Unit = suspendTransaction {
        TeamDao.new {
            name = team.name
            modality = team.modality
            description = team.description
        }
    }

    override suspend fun getTeam(teamId: String): TeamModel? = suspendTransaction {
        TeamDao.find { (TeamTable.id eq teamId.toInt()) }.limit(1).map { it.toModel() }.firstOrNull()
    }

    override suspend fun getListTeam(): List<TeamModel> = suspendTransaction {
        TeamDao.all().map {
            it.toModel()
        }
    }

    override suspend fun addPlayerOnTeam(playerId: String, teamId: String) = suspendTransaction {
        val player = PlayerDao.find { (PlayerTable.id eq playerId.toInt()) }.firstOrNull()
        if (player == null) {
            throw CustomExceptions.NotFoundException("Player with id $playerId not found")
        }
        val team = TeamDao.find { (TeamTable.id eq teamId.toInt()) }.firstOrNull()
        if (team == null) {
            throw CustomExceptions.NotFoundException("Team with id $teamId not found")
        }

        player.teams = SizedCollection(player.teams + team)

    }
}


