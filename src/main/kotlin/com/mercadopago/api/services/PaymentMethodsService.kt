package com.mercadopago.api.services

import com.mercadopago.api.dtos.PaymentMethodDTO
import com.mercadopago.api.utils.Dictionary
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.text.ParseException
import java.util.*

@Service
class PaymentMethodsService {

    /* Public */

    fun realizePayment(dto : PaymentMethodDTO){

        verifyPaymentMethod(dto)

    }

    /* Utils */

    private fun verifyPaymentMethod(dto : PaymentMethodDTO){

        if(dto.flag.uppercase(Locale.getDefault()) == Dictionary.PAYMENT_BLOCKED)
            throw RuntimeException(Dictionary.ERROR_PAYMENT)

        val valueCompare : Int = parseStringToInteger(dto.dividBy)

        if(valueCompare > 6)
            throw RuntimeException(Dictionary.ERROR_VALUE_PAYMENT)

    }

    private fun parseStringToInteger(value : String) : Int {

        try{
            return value.toInt()

        }catch(e : ParseException){

            throw RuntimeException(Dictionary.PARSE_EXCEPTION_DIVIDEBY)

        }


    }

}
