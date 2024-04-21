package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*

@Entity
class SellerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val note: String,
    val address: String,
    val email: String,
    val telephone: String,
    @OneToMany(mappedBy = "seller")
    val clothes: List<ClothEntity> = emptyList(),
)