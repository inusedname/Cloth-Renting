package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.InventoryItemEntity
import dev.vstd.clothes_renting.data.entity.InventoryItemLogEntity
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.repository.InventoryItemRepository
import dev.vstd.clothes_renting.data.repository.InventoryLogRepository
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class InventoryService(
    private val inventoryItemRepository: InventoryItemRepository,
    private val inventoryLogRepository: InventoryLogRepository
) {
    fun save(inventoryItemEntity: InventoryItemEntity) {
        inventoryItemRepository.save(inventoryItemEntity)
    }
    fun getAllInventoryItems(): List<InventoryItemEntity> {
        return inventoryItemRepository.findAll()
    }
    fun filterByName(name: String): List<InventoryItemEntity> {
        return inventoryItemRepository.findByClothEntityNameContainingIgnoreCase(name)
    }
    fun getAllHistories(): List<InventoryItemLogEntity> {
        return inventoryLogRepository.findAll()
    }
    fun filterByItemId(id: Long): List<InventoryItemLogEntity> {
        return inventoryLogRepository.findByInventoryItemId(id)
    }
    fun buyIn(user: UserEntity, productId: Long, quantity: Int, date: String) {
        val inventoryItemEntity = inventoryItemRepository.findByClothEntityId(productId)
        val logEntity = InventoryItemLogEntity(
            quantity = quantity,
            action = "BUY_IN",
            date = Date.valueOf(date),
            user = user,
            inventoryItem = inventoryItemEntity
        )
        inventoryItemEntity.apply {
            quantityInStock += quantity
            lastUpdate = Date.valueOf(date)
        }

        inventoryLogRepository.save(logEntity)
        inventoryItemRepository.save(inventoryItemEntity)
    }

    fun sellOut(user: UserEntity, productId: Long, quantity: Int, date: String) {
        val inventoryItemEntity = inventoryItemRepository.findByClothEntityId(productId)
        val logEntity = InventoryItemLogEntity(
            quantity = quantity,
            action = "SELL_OUT",
            date = Date.valueOf(date),
            user = user,
            inventoryItem = inventoryItemEntity
        )
        inventoryItemEntity.apply {
            quantityInStock -= quantity
            lastUpdate = Date.valueOf(date)
        }

        inventoryLogRepository.save(logEntity)
        inventoryItemRepository.save(inventoryItemEntity)
    }
}