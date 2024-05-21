package dev.vstd.clothes_renting.validator

import dev.vstd.clothes_renting.controller.form.LoginForm
import org.springframework.validation.Errors
import org.springframework.validation.Validator

class LoginFormValidator: Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return LoginForm::class.java == clazz
    }

    override fun validate(target: Any, errors: Errors) {
        val form = target as LoginForm
        /** must contains number, uppercase, lowercase, special character, and at least 8 characters */
        if (!form.password.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*])(?=\\S+\$).{8,}\$"))) {
            errors.rejectValue("password", "error.password", "Mật khẩu phải chứa ít nhất 1 chữ số, 1 chữ cái viết hoa, 1 chữ cái viết thường, 1 ký tự đặc biệt và có ít nhất 8 ký tự")
        }
    }

}