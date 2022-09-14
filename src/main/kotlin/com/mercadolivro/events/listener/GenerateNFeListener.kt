package com.mercadolivro.events.listener

import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNFeListener (
    private val purchaseService: PurchaseService
){

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        println("Generating NFe")
        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)
        purchaseService.update(purchaseModel)
    }

}