package com.gilberson.infra.database.entity

import com.gilberson.domain.model.TeamModel
import com.gilberson.domain.model.TournamentModel
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object ClashTable: IntIdTable("clash") {

    val date= varchar("date", 50)
    val tournament=reference("tournament_id", TournamentTable)
    val teamOne =reference("team_one_id", TeamTable)
    val teamTwo=reference("team_two_id", TeamTable)
    val result=varchar("result", 50)
    val status=varchar("result", 50)
}

class ClashDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ClashDao>(ClashTable)

    var date by ClashTable.date
    var tournament by TournamentDao referencedOn ClashTable.tournament
    var teamOne by TeamDao referencedOn ClashTable.teamOne
    var teamTwo by TeamDao referencedOn ClashTable.teamTwo
    var result by ClashTable.result
    var status by ClashTable.status
}