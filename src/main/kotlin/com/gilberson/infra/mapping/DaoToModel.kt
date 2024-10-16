package com.gilberson.infra.mapping

import com.gilberson.domain.model.Disputes
import com.gilberson.domain.model.PlayerModel
import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.model.TournamentModel
import com.gilberson.infra.database.entity.PlayerDao
import com.gilberson.infra.database.entity.TeamDao
import com.gilberson.infra.database.entity.TournamentDao

fun PlayerDao.toModel(): PlayerModel = PlayerModel(id.toString(), name, age)
fun TeamDao.toModel(): TeamModel = TeamModel(id.toString(), name, modality, description, players = listOf())
fun TournamentDao.toModel(): TournamentModel =
    TournamentModel(id.toString(), name, listTeams = listOf(), "", "", "", "", Disputes.Elimination)
