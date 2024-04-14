package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Role
import dev.vstd.clothes_renting.data.entity.UserEntity
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MenuController {

    @GetMapping("/")
    fun home(request: HttpServletRequest): String {
        val user: UserEntity = request.getAttribute("user") as UserEntity? ?: return "redirect:/login"

        return when(user.role) {
            Role.ADMIN.id -> {
                "redirect:/admin"
            }

            else -> {
                "redirect:/user"
            }
        }
    }
}