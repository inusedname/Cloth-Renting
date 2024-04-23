package dev.vstd.clothes_renting.controller.form

data class RequestMoreProductForm(
    val sellerId: Int,
    val clothId1: String,
    val quantity1: Int,
    val clothId2: String,
    val quantity2: Int,
    val clothId3: String,
    val quantity3: Int,
)