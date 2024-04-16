package dev.vstd.clothes_renting.domain

data class Cloth(
    val id: Long? = null,
    val name: String,
    val previewImage: String,
    val price: Long,
    val description: String,
    val sellerId: Long,
)