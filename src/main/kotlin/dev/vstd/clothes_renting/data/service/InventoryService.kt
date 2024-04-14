package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.repository.InventoryItemRepository
import dev.vstd.clothes_renting.data.repository.InventoryLogRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(
    private val inventoryItemRepository: InventoryItemRepository,
    private val inventoryLogRepository: InventoryLogRepository
) {
}