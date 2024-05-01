package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.controller.form.UpdateClothForm
import dev.vstd.clothes_renting.data.entity.ClothEntity
import dev.vstd.clothes_renting.data.entity.InventoryItemEntity
import dev.vstd.clothes_renting.data.repository.ClothRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Service
class ClothService(
    private val clothRepository: ClothRepository,
    private val sellerService: SellerService,
    private val inventoryService: InventoryService
) {
    @Transactional
    fun saveCloth(updateClothForm: UpdateClothForm) {
        val seller = sellerService.getSellerById(updateClothForm.sellerId)
        var clothEntity = if (updateClothForm.id == null) {
            ClothEntity(
                name = updateClothForm.name,
                previewImage = updateClothForm.previewImage,
                price = updateClothForm.price,
                description = updateClothForm.description,
                seller = seller,
            )
        } else {
            ClothEntity(
                id = updateClothForm.id,
                name = updateClothForm.name,
                previewImage = updateClothForm.previewImage,
                price = updateClothForm.price,
                description = updateClothForm.description,
                seller = seller,
            )
        }
        clothEntity = clothRepository.save(clothEntity)

        if (updateClothForm.id == null) {
            val inventoryItemEntity = InventoryItemEntity(
                clothEntity = clothEntity, lastUpdate = LocalDateTime.now()
            )
            inventoryService.save(inventoryItemEntity)
        }
    }

    fun getAllClothes(): List<ClothEntity> {
        return clothRepository.findAll()
    }

    fun findClothById(id: Long): ClothEntity? {
        return clothRepository.findById(id).getOrNull()
    }

    fun deleteCloth(id: Long) {
        clothRepository.deleteById(id)
    }
}