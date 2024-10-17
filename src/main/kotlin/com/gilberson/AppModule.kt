package com.gilberson

import com.gilberson.application.usecases.StartTournamentUseCase
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

val repositoryModule = module {
    single { PlayerRepositoryImpl() as PlayerRepository }
    single { TeamRepositoryImpl() as TeamRepository }
    single { TournamentRepositoryImpl() as TournamentRepository }
}
val useCaseModule = module {
    single { StartTournamentUseCase(tournamentRepository = get()) }
}
val controllerModule = module {
    single { PlayerController(repository = get()) }
    single { TeamController(playerRepository = get(), teamRepository = get()) }
    single {
        TournamentController(
            tournamentRepository = get(),
            teamRepository = get(),
            startTournamentUseCase = get()
        )
    }
}
val appModule = listOf(
    repositoryModule,
    useCaseModule,
    controllerModule
)
