package com.mercadopago.api.models

import com.mercadopago.api.dtos.AddressDTO
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tb_address", schema = "api")
class Address(){

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    lateinit var id : UUID
        private set

    @Column
    lateinit var zipCode : String
        private set

    @Column
    lateinit var stateName : String
        private set

    @Column
    lateinit var cityName : String
        private set

    @Column
    lateinit var streetName : String
        private set

    @Column
    lateinit var streetNumber : String
        private set

    constructor(address: AddressDTO) : this(){
        this.zipCode = address.zipCode
        this.stateName = address.stateName
        this.cityName = address.cityName
        this.streetName = address.streetName
        this.streetNumber = address.streetNumber
    }

}