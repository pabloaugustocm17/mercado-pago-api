package com.mercadopago.api.dtos

import java.util.UUID

data class PaymentDTO(
        val paymentMethod : PaymentMethodDTO,
        val products : ArrayList<UUID>,
        val user : UUID
)
