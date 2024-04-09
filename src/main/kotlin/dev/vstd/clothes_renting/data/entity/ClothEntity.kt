package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class ClothEntity(
    @Id @GeneratedValue
    private val id: Long = 0,

    val price: Long,

    var onInventory: Int = 0,

    var onListing: Int = 0,

    var onShipping: Int = 0,

    var onBought: Int = 0,

    @ManyToOne @JoinColumn(name = "seller_id", nullable = false)
    val seller: SellerEntity? = null,

    @ManyToOne @JoinColumn(name = "category_id", nullable = false)
    val category: CategoryEntity? = null,
)