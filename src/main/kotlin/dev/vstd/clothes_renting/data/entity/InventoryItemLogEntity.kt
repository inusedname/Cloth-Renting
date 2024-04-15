package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*

@Entity
class InventoryItemLogEntity(
    @Id @GeneratedValue
    val id: Long = 0,
    val quantity: Int,
    val action: String,
    val timestamp: Long,
    @ManyToOne
    @JoinColumn(name = "inventory_item_id")
    val inventoryItem: InventoryItemEntity,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
)