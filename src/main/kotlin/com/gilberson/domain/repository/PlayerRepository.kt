package com.gilberson.domain.repository

import com.gilberson.DatabaseStore.listPlayers
import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.PlayerModel

class PlayerRepository {
    fun savePlayer(player: PlayerModel) {
        listPlayers.add(player)
    }

    fun getPlayer(id: String): PlayerModel {
        val player: PlayerModel? = listPlayers.find { it.id == id }
        player?.let {
            return it
        } ?: throw CustomExceptions.NotFoundException("Player not found")
    }

    fun getListPlayer(): List<PlayerModel> {
        return listPlayers
    }
}

