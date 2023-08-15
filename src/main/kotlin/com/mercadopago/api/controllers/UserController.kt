package com.mercadopago.api.controllers

import com.mercadopago.api.dtos.CreateUserDTO
import com.mercadopago.api.outputs.ErrorOutput
import com.mercadopago.api.outputs.SuccessOutput
import com.mercadopago.api.services.UserService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/user/")
class UserController (private val userService: UserService){

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun insertUser(
            @RequestBody dto : CreateUserDTO
    ) : ResponseEntity<Any> {

        val user = userService.insertUser(dto)

        return SuccessOutput.successOutputId(user)

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllUsers() : ResponseEntity<Any>{

        val users = userService.getAllUsers()

        return ResponseEntity.ok(users)

    }

    @GetMapping("/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(
            @PathVariable id : UUID
    ) : ResponseEntity<Any>{

        val user = userService.getUserById(id)

        return ResponseEntity.ok(user)

    }

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e : Exception) : ResponseEntity<Any>{

        return ErrorOutput.errorOutput(e.message!!)
    }

}