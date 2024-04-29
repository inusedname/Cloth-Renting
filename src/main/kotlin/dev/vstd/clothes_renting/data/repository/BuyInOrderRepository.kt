package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.BuyInOrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BuyInOrderRepository: JpaRepository<BuyInOrderEntity, Long>