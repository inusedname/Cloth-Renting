package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.InventoryItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryItemRepository: JpaRepository<InventoryItemEntity, Long> {
    fun findByClothEntityName(name: String): List<InventoryItemEntity> {
        return findAll().filter { it.clothEntity.name == name }
    }
}