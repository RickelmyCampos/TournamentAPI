package com.gilberson

import com.gilberson.domain.repository.PlayerRepository
import com.gilberson.domain.repository.TeamRepository
import com.gilberson.domain.repository.TournamentRepository
import com.gilberson.presentation.controllers.PlayerController
import com.gilberson.presentation.controllers.TeamController
import com.gilberson.presentation.controllers.TournamentController
import org.koin.dsl.module
import kotlin.math.sin

val repositoryModule = module {
    single { PlayerRepository() }
    single { TeamRepository() }
    single { TournamentRepository() }
}
val controllerModule = module {
    single { PlayerController(repository = get()) }
    single { TeamController(playerRepository = get(), teamRepository = get()) }
    single { TournamentController(tournamentRepository = get(), teamRepository = get()) }
}
