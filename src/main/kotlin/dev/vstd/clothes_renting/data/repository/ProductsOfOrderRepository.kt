package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.ProductsOfOrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsOfOrderRepository: JpaRepository<ProductsOfOrderEntity, Long>