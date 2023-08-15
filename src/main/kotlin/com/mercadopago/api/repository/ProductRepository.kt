package com.mercadopago.api.repository

import com.mercadopago.api.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository
interface ProductRepository : JpaRepository<Product, UUID>{

    @Query( "SELECT P " +
            "FROM Product AS P " +
            "WHERE P.title = :title " +
            "AND P.description = :description")
    fun returnProductByTitleAndDescription(
            title : String,
            description : String
    ) : Optional<Product>

    @Query( "SELECT P " +
            "FROM Product AS P " +
            "WHERE P.id IN :ids")
    fun returnProductsByIds(
            ids : ArrayList<UUID>
    ) : Optional<ArrayList<Product>>
}