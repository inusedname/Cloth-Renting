package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun login(email: String, password: String): Boolean {
        return userRepository.existsByEmailAndPassword(email, password)
    }

    fun findUserByEmail(email: String): UserEntity? {
        return userRepository.findByEmail(email)
    }
}