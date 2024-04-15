package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.service.AuthService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController(private val authService: AuthService) {
    @GetMapping("/login")
    fun getLogin(request: HttpServletRequest): String {
        val user = request.session.getAttribute(Constants.ATTR_USER) as UserEntity?
        return if (user == null)
            "login"
        else
            "redirect:/"
    }

    @PostMapping("/login")
    fun postLogin(@RequestBody loginBody: LoginBody): String {
        return if (authService.login(loginBody.email, loginBody.password)) {
            "redirect:/"
        } else {
            "redirect:/login"
        }
    }

    class LoginBody(
        val email: String,
        val password: String
    )

    @GetMapping("/signout")
    fun signOut(request: HttpServletRequest): String {
        request.session.invalidate()
        return "redirect:/login"
    }
}