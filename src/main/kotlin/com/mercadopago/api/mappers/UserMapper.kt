package com.mercadopago.api.mappers

import com.mercadopago.api.dtos.UserDTO
import com.mercadopago.api.models.User

class UserMapper {

    fun mapperUser(user : UserDTO) : User{

        return User(
                user.firstName,
                user.lastName,
                user.ddd,
                user.phone
        )

    }

}