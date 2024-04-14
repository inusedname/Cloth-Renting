package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class CategoriesOfCloth(
    @Id @GeneratedValue
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: CategoryEntity,

    @ManyToOne
    @JoinColumn(name = "cloth_id")
    val cloth: ClothEntity
)