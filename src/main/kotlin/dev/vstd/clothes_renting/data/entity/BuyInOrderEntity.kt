package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.*
import java.time.LocalDateTime

/**
 * This is different form the order that normal privileged users make,
 * that this is the order that the shop's admin buy the clothes from the sellers
 */
@Entity
class BuyInOrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    val date: LocalDateTime,

    @OneToMany(mappedBy = "orderEntity")
    val products: List<ProductsOfOrderEntity>? = null,

    @ManyToOne
    @JoinColumn(name = "seller_id")
    val sellerEntity: SellerEntity
)