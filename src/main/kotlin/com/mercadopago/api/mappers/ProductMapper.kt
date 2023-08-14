package com.mercadopago.api.mappers

import com.mercadopago.api.dtos.ProductDTO
import com.mercadopago.api.models.Product

class ProductMapper {

    fun mapperProduct(dto : ProductDTO) : Product{

        return Product(
                dto.title,
                dto.description,
                dto.pictureURL,
                dto.categoryId,
                dto.quantity,
                dto.unitPrice
        )

    }

}