package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.ClothEntity
import dev.vstd.clothes_renting.data.repository.ClothRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ClothService(private val clothRepository: ClothRepository) {
    fun saveCloth(cloth: ClothEntity) {
        clothRepository.save(cloth)
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