package com.mercadopago.api.controllers

import com.mercadopago.api.dtos.ProductDTO
import com.mercadopago.api.outputs.ErrorOutput
import com.mercadopago.api.outputs.SuccessOutput
import com.mercadopago.api.services.ProductService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/product/")
class ProductController(private var productService: ProductService){

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun inserProduct(
            @RequestBody dto : ProductDTO
    ) : ResponseEntity<Any> {

        val id = productService.inserProduct(dto)

        return SuccessOutput.successOutputId(id)

    }

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProductById(
            @PathVariable id : UUID
    ) : ResponseEntity<Any>{

        val product = productService.getProducById(id)

        return ResponseEntity.ok(product)

    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllProducts() : ResponseEntity<Any>{

        return ResponseEntity.ok(productService.getAllProducts())
    }

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e : Exception) : ResponseEntity<Any>{

        return ErrorOutput.errorOutput(e.message!!)
    }

}