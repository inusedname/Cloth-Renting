package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*

@Entity
class CategoriesOfClothEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: CategoryEntity,

    @ManyToOne
    @JoinColumn(name = "cloth_id")
    val cloth: ClothEntity
)