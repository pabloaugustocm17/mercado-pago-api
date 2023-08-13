package com.mercadopago.api.services

import com.mercadopago.api.dtos.UserDTO
import com.mercadopago.api.mappers.UserMapper
import com.mercadopago.api.models.User
import com.mercadopago.api.repository.UserRepository
import com.mercadopago.api.utils.Dictionary
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.Optional
import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {

    /* Vars */

    private val userMapper = UserMapper()

    /* Comunicação BD */

    fun insertUser(dto : UserDTO) : UUID{

        if(verifyUserExist(dto))
            throw RuntimeException(Dictionary.USER_EXIST)

        val user = userMapper.mapperUser(dto)

        userRepository.save(user)

        return user.id
    }

    /* Utils */

    private fun verifyUserExist(dto : UserDTO) : Boolean{

        val user : Optional<User> = userRepository.returnUserByFirstNameAndLastName(dto.firstName, dto.lastName)

        return user.isPresent

    }


}