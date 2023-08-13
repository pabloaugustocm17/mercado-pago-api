package com.mercadopago.api.mappers

import com.mercadopago.api.dtos.CreateUserDTO
import com.mercadopago.api.dtos.UserDTO
import com.mercadopago.api.models.Address
import com.mercadopago.api.models.User

class UserMapper {

    fun mapperUser(dto : UserDTO, address: Address) : User{

        return User(
                dto.firstName,
                dto.lastName,
                dto.ddd,
                dto.phone,
                address
        )

    }

}