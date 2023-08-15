package com.mercadopago.api.controllers

import com.mercadopago.api.dtos.PaymentDTO
import com.mercadopago.api.services.PaymentService
import com.mercadopago.api.services.ProductService
import com.mercadopago.api.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/paymentmethods/")
@RestController
class PaymentController(
        var paymentService: PaymentService,
        var productService : ProductService,
        var userService: UserService,
) {

    @PostMapping
    fun realizePayment(
            @RequestBody dto : PaymentDTO
    ) : ResponseEntity<Any> {

        val user = userService.getUserById(dto.user)

        val products = productService.getProductsByIds(dto.products)

        val payment = paymentService.realizePayment(dto.paymentMethod, user, products)

        return ResponseEntity.ok(payment)
    }

}