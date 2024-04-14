package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.SellerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SellerRepository: JpaRepository<SellerEntity, Long> {
}