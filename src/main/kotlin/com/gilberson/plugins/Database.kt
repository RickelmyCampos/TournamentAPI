package com.gilberson.plugins

import com.gilberson.infra.database.entity.*
import io.github.cdimascio.dotenv.dotenv
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    val dotenv=dotenv()
    val databaseUrl=dotenv["DATABASE_URL"]
    val databaseUser=dotenv["DATABASE_USER"]
    val databasePass=dotenv["DATABASE_PASS"]
    print("$databaseUrl $databaseUser $databasePass")
    Database.connect(
        url = databaseUrl,
        user = databaseUser,
        driver = "org.postgresql.Driver",
        password = databasePass
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