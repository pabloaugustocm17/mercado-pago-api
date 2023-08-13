package com.mercadopago.api.utils

class Dictionary {

    companion object {
        const val PAYMENT_BLOCKED = "VISA"

        const val ERROR_PAYMENT = "A bandeira 'VISA' está bloquada para transações"
        const val ERROR_VALUE_PAYMENT = "Somente é permitido compras com inferior a 6 parcelas"
        const val PARSE_EXCEPTION_DIVIDEBY = "Erro ao converter quantidade de pagamento"
    }

}