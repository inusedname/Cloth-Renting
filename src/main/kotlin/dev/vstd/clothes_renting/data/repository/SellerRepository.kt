package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.SellerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SellerRepository : JpaRepository<SellerEntity, Long> {
    @Query("SELECT * FROM seller_entity ORDER BY " +
            "(SELECT SUM(quantity_in_stock) FROM inventory_item_entity WHERE cloth_id IN " +
            "(SELECT id FROM cloth_entity WHERE seller_id = seller_entity.id))",
        nativeQuery = true)
    fun findAllOrderByClothesInventoryItemQuantityInStockAsc(): List<SellerEntity>
}