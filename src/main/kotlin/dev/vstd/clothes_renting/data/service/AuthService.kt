package dev.vstd.clothes_renting.data.service

import dev.vstd.clothes_renting.data.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthService {
    @Autowired
    private lateinit var userRepository: UserRepository

    fun login(email: String, password: String): Boolean {
        val user = userRepository.findByEmail(email)
        return user?.password == password
    }
}