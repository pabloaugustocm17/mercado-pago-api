package com.mercadopago.api.services

import com.mercadopago.api.dtos.CreateUserDTO
import com.mercadopago.api.dtos.UserDTO
import com.mercadopago.api.mappers.AddressMapper
import com.mercadopago.api.mappers.UserMapper
import com.mercadopago.api.models.User
import com.mercadopago.api.repository.AddressRepository
import com.mercadopago.api.repository.UserRepository
import com.mercadopago.api.utils.Dictionary
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.Optional
import java.util.UUID

@Service
class UserService(
        private val userRepository: UserRepository,
        private val addresRepository: AddressRepository
) {

    /* Vars */

    private val userMapper = UserMapper()

    private val addressMapper = AddressMapper()

    /* Comunicação BD */

    fun insertUser(dto : CreateUserDTO) : UUID{

        if(verifyUserExist(dto.user))
            throw RuntimeException(Dictionary.USER_EXIST)

        val address = addressMapper.mapperAddress(dto.address)
        val user = userMapper.mapperUser(dto.user, address)

        addresRepository.save(address)
        userRepository.saveAndFlush(user)

        return user.id
    }

    fun getAllUsers() : MutableList<User> {

        return userRepository.findAll()
    }

    /* Utils */

    private fun verifyUserExist(dto : UserDTO) : Boolean{

        val user : Optional<User> = userRepository.returnUserByFirstNameAndLastName(dto.firstName, dto.lastName)

        return user.isPresent

    }


}