package com.mercadopago.api.dtos

data class CreateUserDTO(
        val user: UserDTO,
        val address: AddressDTO
)