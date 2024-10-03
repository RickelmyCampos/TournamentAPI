package com.gilberson

import com.gilberson.domain.model.PlayerModel
import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.model.TournamentModel

object DatabaseStore {
    val listPlayers = mutableListOf<PlayerModel>(PlayerModel("p", "jogador", 22))
    val deepCopiedListPlayers = listPlayers.map { player ->
        player.copy() // Isso assume que o PlayerModel tem o método copy
    }.toMutableList()
    val listTeam =
        mutableListOf<TeamModel>(
            TeamModel(
                "t1", "Pain", "Time de Lol", "LOL", players =
                deepCopiedListPlayers
            )
        )
    val deepCopiedListTeam = listTeam.map { team ->
        team.copy() // Isso assume que o PlayerModel tem o método copy
    }.toMutableList()
    val listTournament =
        mutableListOf<TournamentModel>(
            TournamentModel(
                id = "tounament1",
                name = "CBLOL",
                listTeams = deepCopiedListTeam
            )
        )
}