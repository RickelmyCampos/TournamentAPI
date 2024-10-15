package com.gilberson.plugins

import com.gilberson.infra.database.entity.PlayerTable
import com.gilberson.infra.database.entity.TeamTable
import com.gilberson.infra.database.entity.TournamentTable
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
    }
}