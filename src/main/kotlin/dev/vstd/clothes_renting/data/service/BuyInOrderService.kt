package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.BuyInOrderEntity
import dev.vstd.clothes_renting.data.entity.ProductsOfOrderEntity
import dev.vstd.clothes_renting.data.entity.SellerEntity
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.repository.BuyInOrderRepository
import dev.vstd.clothes_renting.data.repository.ProductsOfOrderRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BuyInOrderService(
    private val buyInOrderRepository: BuyInOrderRepository,
    private val productsOfOrderRepository: ProductsOfOrderRepository,
    private val inventoryService: InventoryService
) {
    fun findAll(): List<BuyInOrderEntity> {
        return buyInOrderRepository.findAll()
    }

    fun findByOrderId(orderId: Long): BuyInOrderEntity {
        return buyInOrderRepository.findById(orderId).get()
    }

    fun buyIn(
        user: UserEntity,
        sellerEntity: SellerEntity,
        date: LocalDateTime,
        clothes: List<ProductsOfOrderEntity>
    ): BuyInOrderEntity {
        // Create order
        val tmpEntity = BuyInOrderEntity(
            user = user,
            date = date,
            sellerEntity = sellerEntity,
        )
        val savedEntity = buyInOrderRepository.save(tmpEntity)
        clothes.forEach {
            it.orderEntity = savedEntity
        }
        productsOfOrderRepository.saveAll(clothes)

        // Update inventory
        inventoryService.buyIn(
            user = user,
            date = date,
            changes = clothes.associate { it.clothEntity.inventoryItem!!.id to it.quantity })

        return savedEntity
    }
}