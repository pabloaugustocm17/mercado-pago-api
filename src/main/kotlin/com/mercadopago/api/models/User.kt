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

    @Column
    lateinit var firstName : String
        private set

    @Column
    lateinit var lastName : String
        private set

    @Column
    lateinit var ddd : String
        private set

    @Column
    lateinit var phone : String
        private set

    @Column
    lateinit var email : String
        private set

    @OneToOne
    @JoinColumn
    lateinit var address: Address
        private set

    constructor(firstName : String, lastName : String, ddd : String, phone : String, add: Address, email: String) :
            this() {
        this.firstName = firstName
        this.lastName = lastName
        this.ddd = ddd
        this.phone = phone
        this.address = add
        this.email = email
    }
}