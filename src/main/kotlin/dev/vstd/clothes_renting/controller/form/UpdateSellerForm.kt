package dev.vstd.clothes_renting.controller.form

import jakarta.validation.constraints.NotBlank

data class UpdateSellerForm(
    val id: Long? = null,
    @field:NotBlank
    val telephone: String,
    @field:NotBlank
    val email: String,
    val note: String,
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val address: String
)