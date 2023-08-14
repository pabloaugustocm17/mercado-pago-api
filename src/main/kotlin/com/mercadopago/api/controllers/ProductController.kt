package com.mercadopago.api.controllers

import com.mercadopago.api.dtos.ProductDTO
import com.mercadopago.api.services.ProductService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/product/")
class ProductController(private var productService: ProductService){

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun inserProduct(
            @RequestBody dto : ProductDTO
    ) : ResponseEntity<Any> {

        val id = productService.inserProduct(dto)

        return ResponseEntity.ok(id)

    }


    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllProducts() : ResponseEntity<Any>{

        return ResponseEntity.ok(productService.getAllProducts())
    }

}