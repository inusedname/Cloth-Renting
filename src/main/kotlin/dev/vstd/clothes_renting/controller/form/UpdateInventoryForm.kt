package dev.vstd.clothes_renting.controller.form

data class UpdateInventoryForm(
    val productId: Long,
    val type: Int,
    val quantity: Int,
    val date: String
)