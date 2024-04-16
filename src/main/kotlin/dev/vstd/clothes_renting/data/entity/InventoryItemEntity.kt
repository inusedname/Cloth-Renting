package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*
import java.sql.Date

@Entity
class InventoryItemEntity(
    @Id @GeneratedValue
    val id: Long = 0,
    val quantityInStock: Int = 0,
    @OneToOne
    @JoinColumn(name = "cloth_id")
    val clothEntity: ClothEntity,
    val lastUpdate: Date
)