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

    val previewImage: String,

    val description: String,

    @ManyToOne @JoinColumn(name = "seller_id", nullable = false)
    val seller: SellerEntity? = null,

    @ManyToOne @JoinColumn(name = "category_id", nullable = false)
    val category: CategoryEntity? = null,
)