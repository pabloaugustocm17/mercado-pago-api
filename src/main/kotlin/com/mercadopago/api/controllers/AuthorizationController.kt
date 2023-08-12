package com.mercadopago.api.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/")
@RestController
class AuthorizationController{


    @GetMapping
    fun realizeTeste() : ResponseEntity<Any>{

        return ResponseEntity.ok("OK");
    }


}