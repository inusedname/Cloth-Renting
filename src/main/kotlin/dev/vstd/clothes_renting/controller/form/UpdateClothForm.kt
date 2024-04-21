package dev.vstd.clothes_renting.controller.form

data class UpdateClothForm(
    val id: Long? = null,
    val name: String,
    val previewImage: String,
    val price: Long,
    val description: String,
    val sellerId: Long,
)