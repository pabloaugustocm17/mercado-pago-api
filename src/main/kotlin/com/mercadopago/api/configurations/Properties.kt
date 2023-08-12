package com.mercadopago.api.configurations

import com.mercadopago.MercadoPagoConfig
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class Properties {

    val accessToken : String = System.getenv("access_token")!!

    val integratorId : String = System.getenv("public_key")!!

    @EventListener(ApplicationStartedEvent::class)
    fun setupOauth(){
        MercadoPagoConfig.setAccessToken(accessToken)
        MercadoPagoConfig.setIntegratorId(integratorId)
    }

}