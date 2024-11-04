package com.gilberson.infra.repository

import com.gilberson.domain.model.ClashModel
import com.gilberson.domain.repository.ClashRepository
import com.gilberson.infra.database.entity.*
import com.gilberson.infra.database.entity.ClashTable.reference
import com.gilberson.infra.database.entity.ClashTable.varchar

class ClashRepositoryImpl : ClashRepository {
    override suspend fun saveClash(clash: ClashModel):Unit = suspendTransaction{
        val tournamentDao = TournamentDao.findById(clash.tournamentId.toInt())
            ?: throw IllegalArgumentException("Tournament not found")

        val teamOneDao = TeamDao.findById(clash.teamOneId.toInt())
            ?: throw IllegalArgumentException("Team one not found")

        val teamTwoDao = TeamDao.findById(clash.teamTwoId.toInt())
            ?: throw IllegalArgumentException("Team two not found")

        ClashDao.new {
            date = clash.date
            tournament = tournamentDao
            teamOne = teamOneDao
            teamTwo = teamTwoDao
            result = clash.result
            status = clash.status
        }
    }
}