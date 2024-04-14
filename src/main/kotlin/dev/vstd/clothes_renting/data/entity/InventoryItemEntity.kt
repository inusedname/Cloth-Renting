package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*

@Entity
class InventoryItemEntity(
    @Id @GeneratedValue
    private val id: Long = 0,
    val quantityInStock: Int = 0,
    @OneToOne
    @JoinColumn(name = "cloth_id")
    val clothEntity: ClothEntity
)