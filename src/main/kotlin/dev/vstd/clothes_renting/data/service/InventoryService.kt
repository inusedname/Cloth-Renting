package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.entity.InventoryItemEntity
import dev.vstd.clothes_renting.data.entity.InventoryItemLogEntity
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.repository.InventoryItemRepository
import dev.vstd.clothes_renting.data.repository.InventoryLogRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

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
    fun findByInventoryItemIdAndDateIsBetween(id: Long, start: LocalDateTime, end: LocalDateTime): List<InventoryItemLogEntity> {
        return inventoryLogRepository.findByInventoryItemIdAndDateIsBetween(id, start, end)
    }

    @Transactional
    fun buyIn(user: UserEntity, date: LocalDateTime, productId: Long, quantity: Int) {
        // update item
        val inventoryItemEntity = inventoryItemRepository.findByClothEntityId(productId)
        inventoryItemEntity.apply {
            quantityInStock += quantity
            lastUpdate = date
        }
        val savedItem = inventoryItemRepository.save(inventoryItemEntity)

        // Update log
        val logEntity = InventoryItemLogEntity(
            quantity = quantity,
            action = Constants.BUY_IN,
            date = date,
            user = user,
            inventoryItem = savedItem
        )
        inventoryLogRepository.save(logEntity)
    }

    @Transactional
    fun buyIn(user: UserEntity, date: LocalDateTime, changes: Map<Long, Int>) {
        changes.forEach { (productId, quantity) ->
            buyIn(user, date, productId, quantity)
        }
    }

    fun sellOut(user: UserEntity, date: LocalDateTime, productId: Long, quantity: Int) {
        val inventoryItemEntity = inventoryItemRepository.findByClothEntityId(productId)
        val logEntity = InventoryItemLogEntity(
            quantity = quantity,
            action = Constants.SELL_OUT,
            date = date,
            user = user,
            inventoryItem = inventoryItemEntity
        )
        inventoryItemEntity.apply {
            quantityInStock -= quantity
            lastUpdate = date
        }

        inventoryLogRepository.save(logEntity)
        inventoryItemRepository.save(inventoryItemEntity)
    }
}