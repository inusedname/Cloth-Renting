package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

@Entity
class SellerEntity(
    @Id @GeneratedValue
    private val id: Long = 0,

    @OneToMany(mappedBy = "seller")
    val clothes: List<ClothEntity> = emptyList(),
)