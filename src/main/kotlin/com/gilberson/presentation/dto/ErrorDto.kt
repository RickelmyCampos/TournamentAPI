package com.gilberson.presentation.dto

import kotlinx.serialization.Serializable

@Serializable

data class ErrorDto(val isSuccess:Boolean,val message: String)
