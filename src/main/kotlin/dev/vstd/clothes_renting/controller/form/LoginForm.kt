package dev.vstd.clothes_renting.controller.form

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class LoginForm(
    @field:Email(message = "Please provide a valid email address.")
    @field:NotBlank(message = "Email is required.")
    val email: String,

    @field:NotBlank(message = "Password is required.")
    @field:Size(min = 8, max = 64)
    val password: String
)