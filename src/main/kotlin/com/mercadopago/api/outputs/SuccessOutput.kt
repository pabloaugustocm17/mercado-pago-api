package com.mercadopago.api.outputs

import com.mercadopago.api.utils.Dictionary
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

class SuccessOutput {

    companion object {
        fun successOutputId(objectReturn : Any) : ResponseEntity<Any>{

            val hash = HashMap<String, Any>()

            hash["id"] = objectReturn
            hash["mensagem"] = Dictionary.GENERIC_SUCCESS_INSERT

            return ResponseEntity(hash, HttpStatusCode.valueOf(Dictionary.SUCCESS_201))

        }
    }

}