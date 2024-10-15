package com.gilberson.presentation.controllers

import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.domain.model.PlayerModel
import com.gilberson.domain.repository.PlayerRepository

class PlayerController(private val repository: PlayerRepository) {

    suspend fun createPlayer(player: PlayerModel) {
        repository.savePlayer(player)
        println("player: $player")
    }

    suspend fun getAllPlayers(): List<PlayerModel> {
        return repository.getListPlayer()
    }

    suspend fun getPlayer(id: String): PlayerModel {
       val player= repository.getPlayer(id)
        player?.let {
            return it
        }?:throw CustomExceptions.NotFoundException("Player not found")
    }
}