package com.gilberson.domain.model

data class ClashModel(
    val id: String,
    val date: String,
    val tournamentId: String,
    val teamOneId: String,
    val teamTwoId: String,
    val result: String,
    val status: String
)