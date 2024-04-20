package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.Role
import dev.vstd.clothes_renting.data.entity.UserEntity
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MenuController {

    @GetMapping("")
    fun home(request: HttpServletRequest): String {
        val user: UserEntity? = request.session.getAttribute(Constants.ATTR_USER) as UserEntity?
        if (user == null)
            return "redirect:/login"

        when(user.role) {
            Role.INVENTOR.id -> return "dashboard_inventor"
            Role.MANAGER.id -> return "dashboard_manager"
            else -> return "redirect:/login"
        }
    }
}