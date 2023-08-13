package com.mercadopago.api.models

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_address", schema = "api")
class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    lateinit var id : UUID

    lateinit var zipCode : String

    lateinit var stateName : String

    lateinit var cityName : String

    lateinit var streetName : String

    lateinit var streetNumber : String

}