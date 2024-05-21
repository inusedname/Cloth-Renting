package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.controller.form.LoginForm
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.service.UserService
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.util.logging.Logger

@Controller
class LoginController(private val userService: UserService) {
    private val logger = Logger.getLogger(this::class.qualifiedName)

    @GetMapping("/login")
    fun getLogin(request: HttpServletRequest, model: Model): String {
        model.addAttribute("loginForm", LoginForm("",""))
        val user = request.session.getAttribute(Constants.ATTR_USER) as UserEntity?
        return if (user == null)
            "login"
        else
            "redirect:/"
    }

    @PostMapping("/login")
    fun postLogin(
        @Valid @ModelAttribute("loginForm") loginForm: LoginForm,
        bindingResult: BindingResult,
        request: HttpServletRequest,
    ): String {
//        LoginFormValidator().validate(loginForm, bindingResult)
        if (bindingResult.hasErrors()) {
            return "login"
        }
        return if (userService.login(loginForm.email, loginForm.password)) {
            request.session.setAttribute(Constants.ATTR_USER, userService.findUserByEmail(loginForm.email))
            "redirect:/"
        } else {
            bindingResult.rejectValue("email", "error.login", "Email hoặc mật khẩu không đúng")
            "login"
        }
    }



    @GetMapping("/signout")
    fun signOut(request: HttpServletRequest): String {
        request.session.invalidate()
        return "redirect:/login"
    }
}