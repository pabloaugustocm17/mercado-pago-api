package com.mercadopago.api.outputs

import com.mercadopago.api.utils.Dictionary
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

class ErrorOutput {

    companion object {
        fun errorOutput(message : String) : ResponseEntity<Any> {

            val hash = HashMap<String, Any>()

            hash["mensagem"] = message

            return ResponseEntity(hash, HttpStatusCode.valueOf( Dictionary.SUCCESS_202))

        }
    }

}