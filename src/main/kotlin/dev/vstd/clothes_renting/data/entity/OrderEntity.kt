package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*
import java.sql.Date
import java.time.LocalDate

@Entity
class OrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    val date: Date,

    @OneToMany(mappedBy = "orderEntity")
    val products: List<ProductsOfOrderEntity>? = null,

    @ManyToOne
    @JoinColumn(name = "seller_id")
    val sellerEntity: SellerEntity
)