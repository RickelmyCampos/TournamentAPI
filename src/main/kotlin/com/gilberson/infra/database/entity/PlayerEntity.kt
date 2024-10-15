package com.gilberson.infra.database.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object PlayerTable : IntIdTable("player") {

    val name = varchar("name", 50)
    val age = integer("age")
}

class PlayerDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PlayerDao>(PlayerTable)

    var name by PlayerTable.name
    var age by PlayerTable.age
}

