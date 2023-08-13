package com.mercadopago.api.dtos

data class ProductDTO(
        val title : String,
        val description : String,
        val pictureURL : String,
        val categoryId : String,
        val quantity : Int,
        val unitPrice : Double,
)
