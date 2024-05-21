package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.controller.form.UpdateSellerForm
import dev.vstd.clothes_renting.data.service.SellerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/seller")
class SellerController(private val sellerService: SellerService) {

    @GetMapping("")
    fun dashboard(model: Model): String {
        model[Constants.ATTR_SELLERS] = sellerService.getSellers()
        return "dashboard_sellers"
    }

    @GetMapping("/detail")
    fun detail(@RequestParam id: String, model: Model): String {
        val seller = sellerService.getSellerById(id.toLong())
        if (seller == null) {
            return "404"
        } else {
            model[Constants.ATTR_SELLER_ITEM] = seller
            return "detail_seller"
        }
    }

    @GetMapping("/new")
    fun newSeller(model: Model): String {
        return "add_seller"
    }

    @GetMapping("/edit")
    fun editSeller(@RequestParam id: String, model: Model): String {
        val seller = sellerService.getSellerById(id.toLong())
        if (seller == null) {
            return "404"
        } else {
            model[Constants.ATTR_SELLER_ITEM] = seller
            return "add_seller"
        }
    }

    @PostMapping("/save")
    fun saveSeller(updateSellerForm: UpdateSellerForm): String {
        sellerService.saveSeller(updateSellerForm)
        return "redirect:/seller"
    }
}