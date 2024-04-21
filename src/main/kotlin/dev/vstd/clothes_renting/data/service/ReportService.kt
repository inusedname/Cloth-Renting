package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.repository.InventoryItemRepository
import dev.vstd.clothes_renting.data.repository.InventoryLogRepository
import dev.vstd.clothes_renting.data.repository.SellerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.sql.Date
import java.time.LocalDate

@Service
@RequestMapping("/report")
class ReportService(
    private val inventoryLogRepo: InventoryLogRepository,
    private val inventoryRepo: InventoryItemRepository,
    private val sellerRepo: SellerRepository,
) {
    data class SellerRating(
        val sellerId: Long,
        val name: String,
        val buyIn: Int,
        val onInventory: Int,
    )

    @GetMapping("/seller")
    fun getSellerRatings(limit: Int, month: LocalDate): List<SellerRating> {
        val rated = sellerRepo.findAllOrderByClothesInventoryItemQuantityInStockAsc().reversed().take(limit)
        return rated.map { seller ->
            val buyIn = seller.clothes.sumOf { cloth ->
                val logs = inventoryLogRepo.findByInventoryItemIdAndDateIsBetween(
                    cloth.id,
                    Date.valueOf(month.withDayOfMonth(1)),
                    Date.valueOf(month.withDayOfMonth(month.lengthOfMonth()))
                )
                logs.filter { it.action == Constants.BUY_IN }.sumOf { it.quantity }
            }
            val onInventory = seller.clothes.sumOf { it.inventoryItem!!.quantityInStock }
            SellerRating(seller.id, seller.name, buyIn, onInventory)
        }
    }
}