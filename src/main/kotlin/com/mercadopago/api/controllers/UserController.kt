package com.mercadopago.api.controllers

import com.mercadopago.api.dtos.UserDTO
import com.mercadopago.api.mappers.OutputMapper
import com.mercadopago.api.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/user/")
class UserController (private val userService: UserService){

    private val outputMapper = OutputMapper()

    @PostMapping
    fun insertUser(
            @RequestBody dto : UserDTO
    ) : ResponseEntity<Any> {

        val user = userService.insertUser(dto)

        return ResponseEntity.ok(outputMapper.createSuccessResponse(user))

    }

}