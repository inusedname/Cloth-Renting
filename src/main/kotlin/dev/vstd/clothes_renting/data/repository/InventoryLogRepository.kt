package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.InventoryItemLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.sql.Date

interface InventoryLogRepository: JpaRepository<InventoryItemLogEntity, Long> {
    fun findByInventoryItemId(id: Long): List<InventoryItemLogEntity>
    fun findByInventoryItemIdAndDateIsBetween(id: Long, start: Date, end: Date): List<InventoryItemLogEntity>
}