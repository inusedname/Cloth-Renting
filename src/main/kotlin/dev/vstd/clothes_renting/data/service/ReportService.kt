package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.repository.InventoryLogRepository
import dev.vstd.clothes_renting.data.repository.SellerRepository
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Service
class ReportService(
    private val inventoryLogRepo: InventoryLogRepository,
    private val sellerRepo: SellerRepository,
) {
    @Autowired
    lateinit var entityManager: EntityManager

    data class SellerConsumingRating(
        val sellerId: Long,
        val name: String,
        val buyIn: Int,
        val onInventory: Int,
    )

    data class SellerSalesRating(
        val sellerId: Long,
        val name: String,
        val totalOrders: Long,
        val totalSales: BigDecimal,
    )

    fun getSellerConsumingRatings(limit: Int, month: LocalDate): List<SellerConsumingRating> {
        val rated = sellerRepo.findAllOrderByClothesInventoryItemQuantityInStockAsc().reversed().take(limit)
        return rated.map { seller ->
            val buyIn = seller.clothes.sumOf { cloth ->
                val logs = inventoryLogRepo.findByInventoryItemIdAndDateIsBetween(
                    cloth.id,
                    LocalDateTime.of(month, LocalTime.of(0, 0)).withDayOfMonth(1),
                    LocalDateTime.of(month, LocalTime.of(0, 0)).withDayOfMonth(month.lengthOfMonth())
                )
                logs.filter { it.action == Constants.BUY_IN }.sumOf { it.quantity }
            }
            val onInventory = seller.clothes.sumOf { it.inventoryItem!!.quantityInStock }
            SellerConsumingRating(seller.id, seller.name, buyIn, onInventory)
        }
    }

    fun getSellerSalesRatings(limit: Int, start: LocalDate, end: LocalDate): List<SellerSalesRating> {
        val sql = """
            SELECT seller_id, seller_entity.name, COUNT(*) as total_orders, SUM(order_total_sales.total_sales) as total_sales
            FROM buy_in_order_entity
            INNER JOIN (
                SELECT order_id, SUM(quantity*snapshot_price) as total_sales
                FROM products_of_order_entity
                WHERE (order_id IN (
                    SELECT id
                    FROM buy_in_order_entity
                ))
                GROUP BY order_id
            ) as order_total_sales ON buy_in_order_entity.id = order_id
            INNER JOIN seller_entity ON buy_in_order_entity.seller_id = seller_entity.id
            WHERE buy_in_order_entity.date BETWEEN :startDate AND :endDate
            GROUP BY seller_id;
        """.trimIndent()
        val q = entityManager.createNativeQuery(sql)
        val result = q
            .setParameter("startDate", start)
            .setParameter("endDate", end)
            .resultList

        return result.map {
            val it2 = it as Array<*>
            SellerSalesRating(
                it2[0] as Long,
                it2[1] as String,
                it2[2] as Long,
                it2[3] as BigDecimal
            )
        }
    }
}