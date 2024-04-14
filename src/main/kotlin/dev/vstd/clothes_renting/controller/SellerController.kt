package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.data.service.SellerService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/seller")
class SellerController(private val sellerService: SellerService) {

    @GetMapping("/dashboard")
    fun dashboard(): String {
        TODO("Not yet implemented")
    }

    @PostMapping("/new-seller")
    fun postNewCloth(): String {
        TODO("Not yet implemented")
    }

    @PutMapping("/edit-seller")
    fun putEditCloth(): String {
        TODO("Not yet implemented")
    }

    @GetMapping("/detail?id={id}")
    fun detail(@PathVariable id: String): String {
        TODO("Not yet implemented")
    }
}