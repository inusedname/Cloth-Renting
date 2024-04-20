package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.SellerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/seller")
class SellerController(private val sellerService: SellerService) {

    @GetMapping("")
    fun dashboard(model: Model): String {
        val sellers = sellerService.getSellers()
        model[Constants.ATTR_SELLERS] = sellers
        return "dashboard_sellers"
    }

    @GetMapping("/detail")
    fun detail(@RequestParam id: String): String {
        val seller = sellerService.getSellerById(id.toLong())
        if (seller == null) {
            return "404"
        } else {
            TODO()
        }
    }
}