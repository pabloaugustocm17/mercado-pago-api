package com.mercadopago.api.services

import com.mercadopago.api.dtos.ProductDTO
import com.mercadopago.api.mappers.ProductMapper
import com.mercadopago.api.models.Product
import com.mercadopago.api.repository.ProductRepository
import com.mercadopago.api.utils.Dictionary
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.UUID

@Service
class ProductService(private var productRepository: ProductRepository) {

    /* Vars */

    private val productMapper = ProductMapper()

    /* Comunicação BD */

    fun inserProduct(dto : ProductDTO) : UUID{

        if(verifyProduct(dto))
            throw RuntimeException(Dictionary.PRODUCT_EXIST)

        val product = productMapper.mapperProduct(dto)

        productRepository.save(product)

        return product.id
    }

    fun getAllProducts(): MutableList<Product> {

        return productRepository.findAll()

    }

    fun getProductsByIds(ids : ArrayList<UUID>) : ArrayList<Product>{

        val products = productRepository.returnProductsByIds(ids)

        if(products.isEmpty)
            throw RuntimeException(Dictionary.PRODUCT_NO_EXIST)

        return products.get()
    }

    fun getProducById(id : UUID) : Product{

        val product = productRepository.findById(id)

        if(product.isEmpty)
            throw RuntimeException(Dictionary.PRODUCT_NO_EXIST)

        return product.get()
    }

    /* Utils */

    fun verifyProduct(dto : ProductDTO) : Boolean{

        val product = productRepository.returnProductByTitleAndDescription(dto.title, dto.description)

        return product.isPresent

    }

}