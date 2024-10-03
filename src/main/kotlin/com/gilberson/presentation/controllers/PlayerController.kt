package com.gilberson.presentation.controllers

import com.gilberson.domain.model.PlayerModel
import com.gilberson.domain.repository.PlayerRepository

class PlayerController(private val repository: PlayerRepository) {

    fun createPlayer(player: PlayerModel) {
        repository.savePlayer(player)
        println("player: $player")
    }

    fun getAllPlayers(): List<PlayerModel> {
        return repository.getListPlayer()
    }

    fun getPlayer(id: String): PlayerModel = repository.getPlayer(id)
}