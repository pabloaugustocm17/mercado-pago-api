package com.mercadopago.api.dtos

data class PaymentDTO(
        val paymentMethod : PaymentMethodDTO,
        val products : ArrayList<ProductDTO>,
        val user : UserDTO,
        val address : AddressDTO
)
