package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<OrderEntity, Long>