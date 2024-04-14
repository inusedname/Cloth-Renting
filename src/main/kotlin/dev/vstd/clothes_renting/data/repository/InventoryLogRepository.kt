package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.InventoryItemLogEntity
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryLogRepository: JpaRepository<InventoryItemLogEntity, Long> {
}