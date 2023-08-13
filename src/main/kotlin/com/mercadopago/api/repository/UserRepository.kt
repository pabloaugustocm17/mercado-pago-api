package com.mercadopago.api.repository

import com.mercadopago.api.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, UUID>{

    @Query( "SELECT U " +
            "FROM User U " +
            "WHERE U.firstName = :firstName " +
            "AND U.lastName = :lastName")
    fun returnUserByFirstNameAndLastName(firstName : String, lastName : String) : Optional<User>

}
