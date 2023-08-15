package com.mercadopago.api.dtos

import org.springframework.lang.NonNull

data class UserDTO(
        @NonNull val firstName : String,
        @NonNull val lastName : String,
        @NonNull val ddd : String,
        @NonNull val phone : String
)
