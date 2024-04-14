package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.ClothEntity
import dev.vstd.clothes_renting.data.repository.ClothRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClothService(private val clothRepository: ClothRepository) {
    fun saveCloth(cloth: ClothEntity) {
        clothRepository.save(cloth)
    }

    fun getClothes(): List<ClothEntity> {
        return clothRepository.findAll()
    }

    fun deleteCloth(id: Long) {
        clothRepository.deleteById(id)
    }
}