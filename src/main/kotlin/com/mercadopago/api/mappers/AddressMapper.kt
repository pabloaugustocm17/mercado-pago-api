package com.mercadopago.api.mappers

import com.mercadopago.api.dtos.AddressDTO
import com.mercadopago.api.models.Address

class AddressMapper {

    fun mapperAddress(dto : AddressDTO) : Address{
        return Address(dto)
    }

}