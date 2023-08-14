package com.mercadopago.api.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_product", schema = "api")
class Product() {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    lateinit var id : UUID
        private set

    @Column
    lateinit var title : String
        private set

    @Column
    lateinit var description : String
        private set

    @Column
    lateinit var pictureURL : String
        private set

    @Column
    lateinit var categoryId : String
        private set

    @Column
    var quantity : Int = 0
        private set

    @Column
    var unitPrice : Float = 0.0F
        private set

    constructor(title : String, description : String, pictureURL : String, categoryId : String,
            quantity : Int, unitPrice : Float) : this(){

        this.title = title
        this.description = description
        this.pictureURL = pictureURL
        this.categoryId = categoryId
        this.quantity = quantity
        this.unitPrice = unitPrice
    }
}