package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): UserEntity?
}