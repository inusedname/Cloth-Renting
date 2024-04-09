package dev.vstd.clothes_renting.data.repository

import dev.vstd.clothes_renting.data.entity.ClothEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClothRepository: JpaRepository<ClothEntity, Long>