package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.controller.form.LoginForm
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.service.AuthService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.logging.Logger

@Controller
class LoginController(private val authService: AuthService) {
    private val logger = Logger.getLogger(this::class.qualifiedName)

    @GetMapping("/login")
    fun getLogin(request: HttpServletRequest): String {
        val user = request.session.getAttribute(Constants.ATTR_USER) as UserEntity?
        return if (user == null)
            "login"
        else
            "redirect:/"
    }

    @PostMapping("/login")
    fun postLogin(loginForm: LoginForm, request: HttpServletRequest): String {
        return if (authService.login(loginForm.email, loginForm.password)) {
            request.session.setAttribute(Constants.ATTR_USER, authService.findUserByEmail(loginForm.email))
            "redirect:/"
        } else {
            "redirect:/login"
        }
    }



    @GetMapping("/signout")
    fun signOut(request: HttpServletRequest): String {
        request.session.invalidate()
        return "redirect:/login"
    }
}