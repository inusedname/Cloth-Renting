package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*

@Entity
class ClothEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val price: Long,
    val previewImage: String,
    val description: String,
    @ManyToOne @JoinColumn(name = "seller_id", nullable = false)
    val seller: SellerEntity? = null,
    @OneToMany(mappedBy = "cloth")
    val categories: Set<CategoriesOfClothEntity>? = null,
    @OneToOne(mappedBy = "clothEntity")
    val inventoryItem: InventoryItemEntity? = null
)