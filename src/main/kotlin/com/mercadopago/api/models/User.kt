package com.mercadopago.api.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_user", schema = "api")
class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    lateinit var id : UUID
        private set

    private lateinit var firstName : String

    private lateinit var lastName : String

    private lateinit var ddd : String

    private lateinit var phone : String

    constructor(firstName : String, lastName : String, ddd : String, phone : String) : this() {
        this.firstName = firstName
        this.lastName = lastName
        this.ddd = ddd
        this.phone = phone
    }

}