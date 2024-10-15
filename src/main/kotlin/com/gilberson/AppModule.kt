package com.gilberson

import com.gilberson.domain.repository.PlayerRepository
import com.gilberson.domain.repository.TeamRepository
import com.gilberson.domain.repository.TournamentRepository
import com.gilberson.infra.repository.PlayerRepositoryImpl
import com.gilberson.infra.repository.TeamRepositoryImpl
import com.gilberson.infra.repository.TournamentRepositoryImpl
import com.gilberson.presentation.controllers.PlayerController
import com.gilberson.presentation.controllers.TeamController
import com.gilberson.presentation.controllers.TournamentController
import org.koin.dsl.module
import kotlin.math.sin

val repositoryModule = module {
    //single { PlayerRepositoryImpl() }
    //single { TeamRepository() }
    //single { TournamentRepository() }
}
val controllerModule = module {

    single { PlayerController(repository = PlayerRepositoryImpl()) }
    single { TeamController(playerRepository = PlayerRepositoryImpl(), teamRepository = TeamRepositoryImpl()) }
    single {
        TournamentController(
            tournamentRepository = TournamentRepositoryImpl(),
            teamRepository = TeamRepositoryImpl()
        )
    }
}
