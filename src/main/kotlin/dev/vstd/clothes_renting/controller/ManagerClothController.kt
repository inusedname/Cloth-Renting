package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.data.service.ClothService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ManagerClothController {
    @Autowired
    private lateinit var clothService: ClothService

    @GetMapping("/cloth")
    fun allCloth(model: Model): String {
        val clothes = clothService.getClothes()
        model["clothes"] = clothes
        return "clothes_all"
    }
}