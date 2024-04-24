package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.ProductsOfOrderEntity
import dev.vstd.clothes_renting.data.repository.ProductsOfOrderRepository
import org.springframework.stereotype.Service

@Service
class POOService(private val repo: ProductsOfOrderRepository) {
    fun insert(item: ProductsOfOrderEntity) {
        repo.save(item)
    }
}