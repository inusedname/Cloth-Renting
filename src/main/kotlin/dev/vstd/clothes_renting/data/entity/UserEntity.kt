package dev.vstd.clothes_renting.data.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class UserEntity(
    @Id @GeneratedValue
    private val id: Long = 0,
    val username: String,
    val password: String,
    val email: String,
    val role: Int,
)