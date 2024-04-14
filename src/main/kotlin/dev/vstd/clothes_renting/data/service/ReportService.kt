package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.repository.InventoryItemRepository
import dev.vstd.clothes_renting.data.repository.InventoryLogRepository
import dev.vstd.clothes_renting.data.repository.SellerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Service
@RequestMapping("/report")
class ReportService(
    private val inventoryLogRepo: InventoryLogRepository,
    private val inventoryRepo: InventoryItemRepository,
    private val sellerRepo: SellerRepository,
) {
    @GetMapping("/seller")
    fun seller(): String {
        TODO("Not yet implemented")
    }
}