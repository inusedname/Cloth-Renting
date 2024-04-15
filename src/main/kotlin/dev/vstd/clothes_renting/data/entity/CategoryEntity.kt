package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class CategoryEntity(
    @Id @GeneratedValue
    val id: Long = 0,

    val name: String,
)