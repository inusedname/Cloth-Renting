package dev.vstd.clothes_renting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun hello(): String {
        return "Hello, World!"
    }
}