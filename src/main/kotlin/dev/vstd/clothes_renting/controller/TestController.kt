package dev.vstd.clothes_renting.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
class TestController {

    @GetMapping("/test")
    fun hello(@RequestParam(name="name", required=false, defaultValue="World") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "test"
    }
}