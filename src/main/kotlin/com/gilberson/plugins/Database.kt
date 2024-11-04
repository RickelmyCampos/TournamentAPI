package com.gilberson.plugins

import com.gilberson.infra.database.entity.*
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/tournament",
        user = "postgres",
        password = "adm"
    )
    transaction {
        SchemaUtils.create(PlayerTable)
        SchemaUtils.create(TeamTable)
        SchemaUtils.create(TournamentTable)
        SchemaUtils.create(TeamTournamentTable)
        SchemaUtils.create(PlayerTeamTable)
        SchemaUtils.create(ClashTable)
    }
}