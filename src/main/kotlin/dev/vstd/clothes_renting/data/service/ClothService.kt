package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.ClothEntity
import dev.vstd.clothes_renting.data.repository.ClothRepository
import dev.vstd.clothes_renting.domain.Cloth
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ClothService(private val clothRepository: ClothRepository, private val sellerService: SellerService) {
    fun saveCloth(cloth: Cloth) {
        val seller = sellerService.getSellerById(cloth.sellerId)
        val clothEntity = if (cloth.id == null) {
            ClothEntity(
                name = cloth.name,
                previewImage = cloth.previewImage,
                price = cloth.price,
                description = cloth.description,
                seller = seller,
            )
        } else {
            ClothEntity(
                id = cloth.id,
                name = cloth.name,
                previewImage = cloth.previewImage,
                price = cloth.price,
                description = cloth.description,
                seller = seller,
            )
        }
        clothRepository.save(clothEntity)
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