package com.gilberson.infra.database.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object PlayerTeamTable:IntIdTable("player_team"){
    val player=reference("player_id", PlayerTable)
    val team=reference("team_id", TeamTable)
}