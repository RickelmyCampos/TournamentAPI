package com.gilberson.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PlayerModel(val id:String,val name:String,val age:Int)
