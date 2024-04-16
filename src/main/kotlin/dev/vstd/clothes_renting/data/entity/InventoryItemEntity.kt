package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*
import java.sql.Date
import java.sql.Timestamp

@Entity
class InventoryItemEntity(
    @Id @GeneratedValue
    val id: Long = 0,
    var quantityInStock: Int = 0,
    @OneToOne
    @JoinColumn(name = "cloth_id")
    val clothEntity: ClothEntity,
    var lastUpdate: Date
)