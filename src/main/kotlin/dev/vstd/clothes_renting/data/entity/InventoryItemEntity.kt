package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class InventoryItemEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var quantityInStock: Int = 0,
    @OneToOne
    @JoinColumn(name = "cloth_id")
    val clothEntity: ClothEntity,
    var lastUpdate: LocalDateTime
)