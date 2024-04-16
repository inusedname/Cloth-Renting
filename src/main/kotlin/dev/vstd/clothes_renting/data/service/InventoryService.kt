package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.InventoryItemEntity
import dev.vstd.clothes_renting.data.entity.InventoryItemLogEntity
import dev.vstd.clothes_renting.data.repository.InventoryItemRepository
import dev.vstd.clothes_renting.data.repository.InventoryLogRepository
import org.springframework.stereotype.Service

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
        return inventoryItemRepository.findByClothEntityName(name)
    }
    fun getAllHistories(): List<InventoryItemLogEntity> {
        return inventoryLogRepository.findAll()
    }
    fun filterByItemId(id: Long): List<InventoryItemLogEntity> {
        return inventoryLogRepository.findByInventoryItemId(id)
    }
}