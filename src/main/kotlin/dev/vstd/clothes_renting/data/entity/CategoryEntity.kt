package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*

@Entity
class CategoryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
)