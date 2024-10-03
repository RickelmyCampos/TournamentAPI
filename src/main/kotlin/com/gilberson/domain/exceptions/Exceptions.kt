package com.gilberson.domain.exceptions

sealed class CustomExceptions(message: String) : Exception(message) {
    data class NotFoundException(override val message: String) : CustomExceptions(message)
    data class InternalErrorException(override val message: String) : CustomExceptions(message)
    data class BadRequestException(override val message: String) : CustomExceptions(message)
}
