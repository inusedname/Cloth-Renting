package dev.vstd.clothes_renting.controller.form

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class UpdateClothForm(
    val id: Long? = null,
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:NotBlank(message = "Preview image is required")
    val previewImage: String,
    @field:Min(1, message = "Price must be greater than 0")
    val price: Long,
    val description: String,
    @field:Min(0, message = "Please choose a seller")
    val sellerId: Long,
) {
    constructor(): this(null, "", "", 0, "", -1)
}