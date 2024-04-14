package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.data.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController(private val authService: AuthService) {
    @GetMapping("/login")
    fun getLogin(email: String, password: String): String {
        TODO("Not yet implemented")
    }

    @PostMapping("/login")
    fun postLogin(email: String, password: String): String {
        return if (authService.login(email, password)) {
            "redirect:/"
        } else {
            "redirect:/login"
        }
    }

    @PostMapping("/login")
    fun signOut(): String {
        TODO("Not yet implemented")
    }
}