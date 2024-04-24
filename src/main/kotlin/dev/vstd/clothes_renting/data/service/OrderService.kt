package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.OrderEntity
import dev.vstd.clothes_renting.data.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {
    fun createOrder(order: OrderEntity): OrderEntity {
        return orderRepository.save(order)
    }
}