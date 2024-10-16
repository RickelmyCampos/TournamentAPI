package com.gilberson.plugins

import com.gilberson.controllerModule
import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.presentation.controllers.PlayerController
import com.gilberson.presentation.controllers.TeamController
import com.gilberson.domain.model.PlayerModel
import com.gilberson.presentation.controllers.TournamentController
import com.gilberson.presentation.dto.*
import com.gilberson.repositoryModule
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureRouting() {
    val playerController by inject<PlayerController>()
    val teamController by inject<TeamController>()
    val tournamentController by inject<TournamentController>()
    routing {
        route("/player") {
            get("/getPlayer/{id}") {
                handleRequest {
                    val id = call.parameters["id"]
                    if (id.isNullOrEmpty()) {
                        throw CustomExceptions.BadRequestException("Bad request id")
                    }
                    playerController.getPlayer(id)
                }
            }
            get("/getAllPlayer") {
                handleRequest {
                    playerController.getAllPlayers()
                }
            }
            post("/createPlayer") {
                handleRequest {
                    val player = call.receive<PlayerModel>()
                    playerController.createPlayer(player)
                }
            }
        }
        route("/team") {
            get("/getAllTeams") {
                handleRequest {
                    teamController.getAllTeams()
                }
            }
            get("/{id}") {
                handleRequest {
                    val id = call.parameters["id"]
                    if (id.isNullOrEmpty()) {
                        throw CustomExceptions.BadRequestException("Bad request id")
                    }
                    teamController.getTeamById(id)
                }

            }
            post("/createTeam") {
                handleRequest {
                    val team = call.receive<CreateTeamDto>()
                    teamController.createTeam(team.toTeamModel())
                }
            }
            post("/addPlayerToTeam/{idTeam}/{idPlayer}") {
                handleRequest {
                    val idPlayer = call.parameters["idPlayer"]
                    val idTeam = call.parameters["idTeam"]
                    if (idPlayer.isNullOrEmpty() || idTeam.isNullOrEmpty()) {
                        throw CustomExceptions.BadRequestException("Bad request id")
                    }
                    teamController.addPlayerToTeam(idPlayer, idTeam)
                }
            }
        }
        route("/tournament") {
            get("/allTournaments") {
                handleRequest {
                    call.respond(tournamentController.getAllTournaments())
                }
            }
            get("/{id}") {
                handleRequest {
                    val id = call.parameters["id"]
                    if (id.isNullOrEmpty()) {
                        throw CustomExceptions.BadRequestException("Bad request id")
                    }
                    tournamentController.getTournamentById(id)
                }

            }
            post("/createTournament") {
                handleRequest {
                    val team = call.receive<CreateTournamentDto>()
                    tournamentController.createTournament(team.toModel())
                }
            }
            post("/start") {
                handleRequest {
                    val idTournament = call.receive<StartTournamentDto>()
                    tournamentController.startTournament(idTournament.id)
                }
            }
            post("/addTeamToTournament/{idTournament}/{idTeam}") {
                handleRequest {
                    val idTournament = call.parameters["idTournament"]
                    val idTeam = call.parameters["idTeam"]
                    if (idTournament.isNullOrEmpty() || idTeam.isNullOrEmpty()) {
                        call.respond(HttpStatusCode.BadRequest)
                        throw CustomExceptions.BadRequestException("Bad request id")
                    }
                    tournamentController.addTeamToTournament(idTeam, idTournament)
                }
            }
        }
    }
}

fun Application.configureDi() {
    install(Koin) {
        slf4jLogger()
        modules(repositoryModule, controllerModule)
    }
}


fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
