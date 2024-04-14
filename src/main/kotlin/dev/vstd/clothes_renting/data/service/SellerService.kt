package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.ClothEntity
import dev.vstd.clothes_renting.data.entity.SellerEntity
import dev.vstd.clothes_renting.data.repository.SellerRepository
import org.springframework.stereotype.Service

@Service
class SellerService(private val sellerRepo: SellerRepository) {
    fun saveSeller(seller: SellerEntity) {
        sellerRepo.save(seller)
    }

    fun getSellers(): List<SellerEntity> {
        return sellerRepo.findAll()
    }
}