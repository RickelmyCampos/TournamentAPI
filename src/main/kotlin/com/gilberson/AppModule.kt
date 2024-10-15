package com.gilberson

import com.gilberson.infra.repository.PlayerRepositoryImpl
import com.gilberson.infra.repository.TeamRepositoryImpl
import com.gilberson.infra.repository.TournamentRepositoryImpl
import com.gilberson.presentation.controllers.PlayerController
import com.gilberson.presentation.controllers.TeamController
import com.gilberson.presentation.controllers.TournamentController
import org.koin.dsl.module

val repositoryModule = module {
//    single { PlayerRepositoryImpl() }
//    single { TeamRepositoryImpl() }
//    single { TournamentRepositoryImpl() }
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
