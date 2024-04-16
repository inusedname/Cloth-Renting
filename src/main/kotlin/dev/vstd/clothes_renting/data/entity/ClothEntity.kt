package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class ClothEntity(
    @Id @GeneratedValue
    val id: Long = 0,
    val name: String,
    val price: Long,
    val previewImage: String,
    val description: String,
    @ManyToOne @JoinColumn(name = "seller_id", nullable = false)
    val seller: SellerEntity? = null,
    @OneToMany(mappedBy = "cloth")
    val categories: Set<CategoriesOfClothEntity>? = null
)