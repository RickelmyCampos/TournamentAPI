package com.gilberson.infra.database.entity

import org.jetbrains.exposed.dao.id.IntIdTable

object TeamTournamentTable: IntIdTable("team_tournament") {
    val team= reference("team_id", TeamTable)
    val tournament= reference("tournament_id", TournamentTable)
}