package com.gilberson.infra.repository

import com.gilberson.domain.model.TournamentModel
import com.gilberson.domain.repository.TournamentRepository
import com.gilberson.infra.database.entity.TournamentDao
import com.gilberson.infra.database.entity.TournamentTable
import com.gilberson.infra.extensions.suspendTransaction
import com.gilberson.infra.mapping.toModel

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
}

