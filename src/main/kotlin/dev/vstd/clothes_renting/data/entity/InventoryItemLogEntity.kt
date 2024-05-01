package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class InventoryItemLogEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val quantity: Int,
    val action: String,
    val date: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "inventory_item_id")
    val inventoryItem: InventoryItemEntity,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
)