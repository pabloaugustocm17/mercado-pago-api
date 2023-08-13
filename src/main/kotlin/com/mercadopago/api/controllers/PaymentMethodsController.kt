package com.mercadopago.api.controllers

import com.mercadopago.api.dtos.PaymentDTO
import com.mercadopago.api.services.PaymentMethodsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/paymentmethods/")
@RestController
class PaymentMethodsController {

    val service = PaymentMethodsService()

    @PostMapping
    fun realizePayment(
            @RequestBody dto : PaymentDTO
    ) : ResponseEntity<Any> {

        val payment = service.realizePayment(dto)

        return ResponseEntity.ok(payment)
    }

}