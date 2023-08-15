package com.mercadopago.api.utils

class Dictionary {

    companion object {
        const val PAYMENT_BLOCKED = "VISA"

        const val ERROR_PAYMENT = "A bandeira 'VISA' está bloquada para transações"
        const val ERROR_VALUE_PAYMENT = "Somente é permitido compras com inferior a 6 parcelas"
        const val PARSE_EXCEPTION_DIVIDEBY = "Erro ao converter quantidade de pagamento"

        const val USER_EXIST = "Usuário já existe no sistema"
        const val USER_NO_EXIST = "Usuário não existe no sistema"
        const val PRODUCT_EXIST = "Produto já inserido no sistema"
        const val PRODUCT_NO_EXIST = "Produto(s) não existe no sistema"

        const val GENERIC_SUCCESS_INSERT = "Objeto inserido com sucesso"

        const val SUCCESS_201 = 201
        const val SUCCESS_202 = 202

    }

}