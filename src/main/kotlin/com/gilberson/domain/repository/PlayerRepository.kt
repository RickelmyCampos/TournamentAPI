package com.gilberson.domain.repository

import com.gilberson.domain.model.PlayerModel
interface PlayerRepository {
    suspend fun savePlayer(player: PlayerModel)
    suspend fun getPlayer(id: String): PlayerModel?
    suspend fun getListPlayer(): List<PlayerModel>
}


