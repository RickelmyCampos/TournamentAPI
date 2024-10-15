package com.gilberson.infra.database.entity

import com.gilberson.infra.database.entity.TeamTable.varchar
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object TeamTable : IntIdTable("team") {

    val name = varchar("name", 50)
    val description = varchar("description", 50)
    val modality = varchar("modality", 50)
    //val players: MutableList<PlayerModel>
}

class TeamDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TeamDao>(TeamTable)

    var name by TeamTable.name
    var description by TeamTable.description
    var modality by TeamTable.modality
}