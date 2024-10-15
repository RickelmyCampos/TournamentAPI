package com.gilberson.infra.database.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object TournamentTable:IntIdTable("tournament") {
    val name = varchar("name", 50)
}
class TournamentDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TournamentDao>(TournamentTable)
    var name by TournamentTable.name
}