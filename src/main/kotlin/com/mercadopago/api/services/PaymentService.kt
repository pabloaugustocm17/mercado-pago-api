package com.mercadopago.api.services

import com.mercadopago.api.dtos.*
import com.mercadopago.api.models.Product
import com.mercadopago.api.models.User
import com.mercadopago.api.repository.ProductRepository
import com.mercadopago.api.repository.UserRepository
import com.mercadopago.api.utils.Dictionary
import com.mercadopago.client.common.PhoneRequest
import com.mercadopago.client.payment.*
import com.mercadopago.resources.payment.Payment
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.math.BigDecimal
import java.text.ParseException
import java.util.*
import kotlin.collections.ArrayList

@Service
class PaymentService {


    /* Public */

    fun realizePayment(
            paymentMethod : PaymentMethodDTO,
            user : User,
            products : ArrayList<Product>
    ) : Payment{

        verifyPaymentMethod(paymentMethod)

        val request = createRequest(paymentMethod, user, products)

        val client = PaymentClient()

        return client.create(request)

    }

    /* Utils */

    private fun createRequest(paymentMethod : PaymentMethodDTO,
                              user : User,
                              productsModel : ArrayList<Product>
    ): PaymentCreateRequest {

        val products = createItemRequest(productsModel)

        val address = user.address

        return PaymentCreateRequest.builder()
                .additionalInfo(
                        PaymentAdditionalInfoRequest.builder()
                                .items(products)
                                .payer(
                                        PaymentAdditionalInfoPayerRequest.builder()
                                                .firstName(user.firstName)
                                                .lastName(user.lastName)
                                                .phone(
                                                        PhoneRequest.builder().areaCode(user.ddd).number(user.phone)
                                                                .build()
                                                )
                                                .build())
                                .shipments(
                                        PaymentShipmentsRequest.builder()
                                                .receiverAddress(
                                                        PaymentReceiverAddressRequest.builder()
                                                                .zipCode(address.zipCode)
                                                                .stateName(address.stateName)
                                                                .cityName(address.cityName)
                                                                .streetName(address.streetName)
                                                                .streetNumber(address.streetName)
                                                                .build())
                                                .build())
                                .build())
                .description("Payment for product")
                .externalReference("MP0001")
                .installments(parseStringToInteger(paymentMethod.installments))
                .order(PaymentOrderRequest.builder().type("mercadolibre").build())
                .payer(PaymentPayerRequest.builder().entityType("individual").type("customer").build())
                .paymentMethodId(paymentMethod.flag)
                .transactionAmount(BigDecimal(products.stream().mapToDouble { product ->
                    product.unitPrice.toDouble() }.sum()))
                .build()
    }

    private fun createItemRequest(products : ArrayList<Product>) : LinkedList<PaymentItemRequest> {

        val items : LinkedList<PaymentItemRequest> = LinkedList()

        products.forEach { product ->

            val item =  PaymentItemRequest.builder()
                            .id(product.id.toString())
                            .title(product.title)
                            .description(product.description)
                            .pictureUrl(product.pictureURL)
                            .categoryId(product.categoryId)
                            .quantity(product.quantity)
                            .unitPrice(BigDecimal(product.unitPrice.toDouble()))
                            .build()

            items.add(item)
        }

        return items

    }

    private fun verifyPaymentMethod(dto : PaymentMethodDTO){

        if(dto.flag.uppercase(Locale.getDefault()) == Dictionary.PAYMENT_BLOCKED)
            throw RuntimeException(Dictionary.ERROR_PAYMENT)

        val valueCompare : Int = parseStringToInteger(dto.installments)

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
