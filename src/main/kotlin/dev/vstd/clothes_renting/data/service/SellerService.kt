package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.controller.form.UpdateSellerForm
import dev.vstd.clothes_renting.data.entity.SellerEntity
import dev.vstd.clothes_renting.data.repository.SellerRepository
import org.springframework.stereotype.Service

@Service
class SellerService(private val sellerRepo: SellerRepository) {
    fun saveSeller(form: UpdateSellerForm) {
        val sellerEntity = (if (form.id == null) {
            SellerEntity(
                name = form.name,
                address = form.address,
                telephone = form.telephone,
                email = form.email,
                note = form.note,
            )
        } else {
            SellerEntity(
                id = form.id,
                name = form.name,
                address = form.address,
                telephone = form.telephone,
                email = form.email,
                note = form.note,
            )
        })
        sellerRepo.save(sellerEntity)
    }

    fun getSellers(): List<SellerEntity> {
        return sellerRepo.findAll()
    }

    fun getSellerById(id: Long): SellerEntity? {
        return sellerRepo.findById(id).orElse(null)
    }

    fun findAllOrderByClothesInventoryItemQuantityInStockAsc(): List<SellerEntity> {
        return sellerRepo.findAllOrderByClothesInventoryItemQuantityInStockAsc()
    }
}