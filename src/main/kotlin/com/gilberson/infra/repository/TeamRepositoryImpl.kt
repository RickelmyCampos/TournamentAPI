package com.gilberson.infra.repository

import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.repository.TeamRepository
import com.gilberson.infra.database.entity.TeamDao
import com.gilberson.infra.database.entity.TeamTable
import com.gilberson.infra.extensions.suspendTransaction
import com.gilberson.infra.mapping.toModel

class TeamRepositoryImpl : TeamRepository {
    override suspend fun saveTeam(team: TeamModel): Unit = suspendTransaction {
        TeamDao.new {
            name = team.name
            modality = team.modality
            description = team.description
        }
    }

    override suspend fun getTeam(teamId: String): TeamModel? = suspendTransaction {
        TeamDao.find { (TeamTable.id eq id.toInt()) }.limit(1).map { it.toModel() }.firstOrNull()
    }

    override suspend fun getListTeam(): List<TeamModel> = suspendTransaction {
        TeamDao.all().map { it.toModel() }
    }
}


