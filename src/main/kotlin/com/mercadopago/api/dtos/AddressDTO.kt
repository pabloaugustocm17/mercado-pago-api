package com.mercadopago.api.dtos

data class AddressDTO(
        val zipCode : String,
        val stateName : String,
        val cityName : String,
        val streetName : String,
        val streetNumber : String
)
