package com.mercadopago.api.dtos

import org.springframework.lang.NonNull

data class AddressDTO(
        @NonNull val zipCode : String,
        @NonNull val stateName : String,
        @NonNull val cityName : String,
        @NonNull val streetName : String,
        @NonNull val streetNumber : String
)
