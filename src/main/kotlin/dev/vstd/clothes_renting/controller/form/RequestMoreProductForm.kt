package dev.vstd.clothes_renting.controller.form

data class RequestMoreProductForm(
    val sellerId: Int,
    val clothId: Int,
    val quantity: Int
)