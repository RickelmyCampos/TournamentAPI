package com.gilberson.infra.repository


import com.gilberson.domain.model.PlayerModel
import com.gilberson.domain.repository.PlayerRepository
import com.gilberson.infra.database.entity.PlayerDao
import com.gilberson.infra.database.entity.PlayerTable
import com.gilberson.infra.extensions.suspendTransaction
import com.gilberson.infra.mapping.toModel

class PlayerRepositoryImpl : PlayerRepository {
    override suspend fun savePlayer(player: PlayerModel): Unit = suspendTransaction {
        PlayerDao.new {
            name = player.name
            age = player.age
        }
    }

    override suspend fun getPlayer(id: String): PlayerModel? = suspendTransaction {
        PlayerDao.find { (PlayerTable.id eq id.toInt()) }.limit(1).map { it.toModel() }.firstOrNull()
    }

    override suspend fun getListPlayer(): List<PlayerModel> = suspendTransaction {
        PlayerDao.all().map { it.toModel() }
    }
}
