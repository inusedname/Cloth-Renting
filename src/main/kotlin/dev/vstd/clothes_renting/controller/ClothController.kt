package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.data.service.ClothService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/cloth")
class ClothController(private val clothService: ClothService) {

    @GetMapping("/dashboard")
    fun dashboard(): String {
        TODO("Not yet implemented")
    }

    @PostMapping("/new-cloth")
    fun postNewCloth(): String {
        TODO("Not yet implemented")
    }

    @PutMapping("/edit-cloth")
    fun putEditCloth(): String {
        TODO("Not yet implemented")
    }

    @GetMapping("/detail?id={id}")
    fun detail(@PathVariable id: String): String {
        TODO("Not yet implemented")
    }
}