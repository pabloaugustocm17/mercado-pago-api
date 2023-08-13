package com.mercadopago.api.mappers

import com.mercadopago.api.outputs.ResponseSuccess

class OutputMapper {

    fun createSuccessResponse(message : Any) : ResponseSuccess {

        return ResponseSuccess(
                HashMap<String, Any>().put(message.javaClass.name, message)
        )
    }

}