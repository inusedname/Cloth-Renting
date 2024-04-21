package dev.vstd.clothes_renting.controller.form

data class UpdateSellerForm(
    val id: Long? = null,
    val telephone: String,
    val email: String,
    val note: String,
    val name: String,
    val address: String
)