package com.gilberson.plugins

import com.gilberson.domain.exceptions.CustomExceptions
import com.gilberson.presentation.dto.ErrorDto
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

suspend fun RoutingContext.handleRequest(function: suspend () -> Any) {
    try {
        val response = function.invoke()
        call.respond(message = response)
    } catch (ex: CustomExceptions) {
        val error = ErrorDto(isSuccess = false, message = ex.message.toString())
        when (ex) {
            is CustomExceptions.BadRequestException -> call.respond(HttpStatusCode.BadRequest, error)
            is CustomExceptions.InternalErrorException -> call.respond(HttpStatusCode.InternalServerError, error)
            is CustomExceptions.NotFoundException -> call.respond(HttpStatusCode.NotFound, error)
        }
    }catch (ex:Exception){
        ex.printStackTrace()
        val error = ErrorDto(isSuccess = false, message = ex.message.toString())
        call.respond(HttpStatusCode.InternalServerError, error)
    }
}